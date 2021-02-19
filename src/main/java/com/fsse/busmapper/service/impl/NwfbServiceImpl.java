package com.fsse.busmapper.service.impl;

import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.RouteStop;
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

        // Step 2:0: use the existing route data to search routeStop


    }

    @Override
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
    // Step 2.0: Load RouteStop
    logger.debug("Fetching route {} in {}", route.getRouteId(), dir);
    List<RouteStop> routeStopDOs = nwfbExtService.loadSpecificRouteStop(route.getRouteId(), dir);
    logger.debug("Done fetch route {} in {}", route.getRouteId(), dir);

    // Step 2.1: Convert routeStopDO into Entity
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


///Final
    @Override
    public void loadAllBusData() {
        // Step 1.0: Load all routes
        List<Route> routeDOs = nwfbExtService.loadAllRoutes();
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


        // Step 2:0: use the existing route data to search routeStop


    }



}
