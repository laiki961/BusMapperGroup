package com.fsse.busmapper.service.impl;

import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.Stop;
import com.fsse.busmapper.domain.dto.response.FetchDataFromCTBResponseDto;
import com.fsse.busmapper.domain.entity.RouteEntity;
import com.fsse.busmapper.domain.entity.RouteStopEntity;
import com.fsse.busmapper.domain.entity.StopEntity;
import com.fsse.busmapper.repository.RouteRepository;
import com.fsse.busmapper.repository.RouteStopRepository;
import com.fsse.busmapper.repository.StopRepository;
import com.fsse.busmapper.service.NwfbService;
import com.fsse.busmapper.service.external.NwfbExtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class NwfbServiceImpl implements NwfbService {
    @Autowired
    private NwfbExtService nwfbExtService;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private RouteStopRepository routeStopRepository;
    @Autowired
    private StopRepository stopRepository;

    Logger logger = LoggerFactory.getLogger(NwfbServiceImpl.class);

    @Override
    public void loadAllRoutes() {
        // Step 1.0: Load all routes
        List<Route> routeDOs = nwfbExtService.loadAllRoutes();
        logger.debug(routeDOs.toString());
        // Step 1.1: Convert the routeDO into RouteEntity
        List<RouteEntity> routeEntities = new ArrayList<>();
        for(int i=0; i<routeDOs.size(); i++) {
            Route routeDO = routeDOs.get(i);
            RouteEntity entity = new RouteEntity();
            entity.setRouteId(routeDO.getRoute());
            entity.setOrig(routeDO.getOrig());
            entity.setDest(routeDO.getDest());
            routeEntities.add(entity);
        }
        // Step 1.2: Save all RouteEntity to database
        routeRepository.saveAll(routeEntities);
    }

    @Override
    // Step 2.3: let the program run 2 direction itself
    public void loadRouteInAndOutboundStop (List<RouteEntity> routeEntities){
        String[] direction = new String[2];
        direction[0] = "inbound";
        direction[1] = "outbound";
        for(int i=0; i<routeEntities.size(); i++){
            for(int j=0; j<direction.length; j++){
                loadRouteDirectionStop(routeEntities.get(i), direction[j]);
                //loadRouteDirectionStop( RouteEntity route, inbound / outbound);
                logger.debug("saved routeID {} ,{} to database: ", routeEntities.get(i).getRouteId(), direction[j]);
            }
        }
    }

    @Override
    public void loadRouteDirectionStop(RouteEntity route, String dir){
    // Step 2.0: Load RouteStop with a single direction
    logger.debug("Fetching route {} in {}", route.getRouteId(), dir);
    List<RouteStop> routeStopDOs = nwfbExtService.loadSpecificRouteStop(route.getRouteId(), dir);
    logger.debug("Done fetch route {} in {}", route.getRouteId(), dir);

    // Step 2.1: Convert routeStopDO into RouteStopEntity
    List<RouteStopEntity> routeStopEntities = new ArrayList<>();
    for (int i=0; i<routeStopDOs.size(); i++){
        logger.debug("Setting routeID. {}, stopNo.{} of {}, {} ", route.getRouteId(), i+1, routeStopDOs.size(), dir);
        RouteStopEntity entity = new RouteStopEntity();
        entity.setCo(routeStopDOs.get(i).getCo());
        entity.setDir(dir);
        entity.setRouteEntity(route);
        entity.setSeq(routeStopDOs.get(i).getSeq());

        StopEntity stop = new StopEntity();
        stop.setStopId(routeStopDOs.get(i).getStop());
        stop.setStopname(null);
        stop.setLatitude(null);
        stop.setLongitude(null);
        stopRepository.save(stop);
        entity.setStopEntity(stop);

        routeStopEntities.add(entity);
    }
    logger.debug("routeStopEntities: {}", routeStopEntities);

    // Step 2.2: Save to database
        routeStopRepository.saveAll(routeStopEntities);
    }

    @Override
    public void loadAllStops(List<RouteStopEntity> routeStops) {
        for (int j=0; j<routeStops.size(); j++){
            logger.debug("stopID {}: Fetching {}/{} ", routeStops.get(j).getStopEntity().getStopId(), j+1, routeStops.size());
            List<Stop> stopDOs = nwfbExtService.loadAllStops(routeStops.get(j).getStopEntity().getStopId());
            logger.debug("StopID {}: Done fetch details, received Stop", routeStops.get(j).getStopEntity().getStopId());

            //if stop details already exist then skip (if latitude doesn't exist in the database[false] [loop] below)
//            if(!stopRepository.existsById(routeStops.get(j).getStopEntity().getLatitude())){
                List<StopEntity> stopEntities = new ArrayList<>();
                for(int i=0; i<stopDOs.size(); i++){
                    logger.debug("Converting [StopDOs] into [StopEntity] {}/{}", i+1, stopDOs.size());
                    StopEntity entity = new StopEntity();
                    entity.setStopId(routeStops.get(j).getStopEntity().getStopId());
                    entity.setStopname(stopDOs.get(i).getStopName());
                    entity.setLatitude(stopDOs.get(i).getLat());
                    entity.setLongitude(stopDOs.get(i).getLng());
                    stopEntities.add(entity);
                    logger.debug("Added [StopEntity] into [List<StopEntity>]");
                }
                stopRepository.saveAll(stopEntities);
                logger.debug("stopID {}: Saved [List<StopEntity>] into database", routeStops.get(j).getStopEntity().getStopId());
//            }else{
//                logger.debug("StopID {}: Already exist in database", routeStops.get(j).getStopEntity().getStopId());
//            }
        }
    }



    
///Final
//    @Override
//    public FetchDataFromCTBResponseDto loadAllBusData() {
//        FetchDataFromCTBResponseDto fetchDataFromCTBResponseDto = new FetchDataFromCTBResponseDto();
//        List<RouteEntity> routeEntities = loadAllRoutes(); // 要改上面return value
//        List<RouteStopEntity> routeStopEntities = loadRouteInAndOutboundStop(routeEntities);
//        loadAllStops(routeStopEntities);
//        return fetchDataFromCTBResponseDto;
//    }

}
