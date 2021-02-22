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

    private void speedLimit() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public List<RouteEntity> loadAllRoutes() {
        // Step 1.0: Load all routes
        List<Route> routeDOs = nwfbExtService.loadAllRoutes();
        logger.debug("Done fetching [Routes from Ext API]");

        // Step 1.1: Convert the routeDO into RouteEntity
        List<RouteEntity> routeEntities = new ArrayList<>();
        for(int i=0; i<routeDOs.size(); i++) {
            logger.debug("Adding {}/{} ", i+1, routeDOs.size());
            Route routeDO = routeDOs.get(i);
            RouteEntity entity = new RouteEntity();
            entity.setRouteId(routeDO.getRoute());
            entity.setOrig(routeDO.getOrig());
            entity.setDest(routeDO.getDest());
            routeEntities.add(entity);
        }
        // Step 1.2: Save all RouteEntity to database
        routeRepository.saveAll(routeEntities);
        logger.debug("Saved [List<RouteEntity> into database]");
        return routeEntities;
    }

    @Override
    // Step 2.3: let the program run 2 direction itself
    public List<StopEntity> loadRouteInAndOutboundStop (List<RouteEntity> routeEntities){
        List<StopEntity> stopEntities = new ArrayList<>();
        List<RouteStopEntity> routeStopEntities = null;
        String[] direction = new String[2];
        direction[0] = "inbound";
        direction[1] = "outbound";
        for(int i=0; i<routeEntities.size(); i++){
            for(int j=0; j<direction.length; j++){
                logger.debug("Total amount of routes: {}, 2 Directions: {}", routeEntities.size(), routeEntities.size()*2);
                logger.debug("{} routes left: ", routeEntities.size()*2 - j);
                routeStopEntities = loadRouteDirectionStop(routeEntities.get(i), direction[j]);
                //loadRouteDirectionStop( RouteEntity route, inbound / outbound);
                logger.debug("saved routeID {}, {} to database", routeEntities.get(i).getRouteId(), direction[j]);
                speedLimit();
            }
        }
        return stopEntities;
    }

    @Override
    public List<RouteStopEntity> loadRouteDirectionStop(RouteEntity route, String dir){
        List<RouteStopEntity> routeStopEntities = new ArrayList<>();
        // Step 2.0: Load RouteStop with a single direction

        logger.debug("Fetching route {} in {}", route.getRouteId(), dir);
        List<RouteStop> routeStopDOs = nwfbExtService.loadSpecificRouteStop(route.getRouteId(), dir);
        logger.debug("Done fetch route {} in {}", route.getRouteId(), dir);

        // Step 2.1: Convert routeStopDO into RouteStopEntity
        for (int i=0; i<routeStopDOs.size(); i++){
            logger.debug("Setting routeID. {}, stopNo.{} of {}, {} ", route.getRouteId(), i+1, routeStopDOs.size(), dir);

            RouteStopEntity routeStopEntity = new RouteStopEntity();
            routeStopEntity.setCo(routeStopDOs.get(i).getCo());
            routeStopEntity.setDir(dir);
            routeStopEntity.setRouteEntity(route);
            routeStopEntity.setSeq(routeStopDOs.get(i).getSeq());

            StopEntity stopEntity = new StopEntity();
            stopEntity.setStopId(routeStopDOs.get(i).getStop());
            stopEntity.setStopname(null);
            stopEntity.setLatitude(null);
            stopEntity.setLongitude(null);
            stopRepository.save(stopEntity);

            routeStopEntity.setStopEntity(stopEntity);

            routeStopEntities.add(routeStopEntity);
            logger.debug("StopID {}: Added routeId to [Stop database] ONLY", routeStopDOs.get(i).getStop());
        }
        // Step 2.2: Save to database
        routeStopRepository.saveAll(routeStopEntities);
        return routeStopEntities;
    }

    @Override
    public void loadAllStops() {
        List<StopEntity> stopEntities = stopRepository.findAll();
        List<Stop> stopDOs = new ArrayList<>();

        for (int j=0; j<stopEntities.size(); j++){
            logger.debug("Total stopID amount {}/{}, left: {}, stopID{} ", j+1, stopEntities.size(), stopEntities.size()-(j+1), stopEntities.get(j).getStopId());

            Stop stopDO = nwfbExtService.loadSpecificStop(stopEntities.get(j).getStopId());
            stopDOs.add(stopDO);

            logger.debug("stopID {}: Setting StopName, Latitude & Longitude", stopEntities.get(j).getStopId() );
            StopEntity entity = new StopEntity();
            entity.setStopId(stopDOs.get(j).getStopId());
            entity.setStopname(stopDOs.get(j).getStopName());
            entity.setLatitude(stopDOs.get(j).getLat());
            entity.setLongitude(stopDOs.get(j).getLng());
            stopRepository.save(entity);
            logger.debug("StopID {}: Added StopId, StopName, Latitude & Longitude to [Stop database]", stopEntities.get(j).getStopId());

            speedLimit();
        }
    }
    
//Final
    @Override
    public FetchDataFromCTBResponseDto loadAllBusData() {
        FetchDataFromCTBResponseDto fetchDataFromCTBResponseDto = new FetchDataFromCTBResponseDto();
        logger.debug("Start calling [Routes from External API]");
        List<RouteEntity> routeEntities = loadAllRoutes();

        logger.debug("Start calling [RouteStops from External API] from [List<RouteEntity>] ");
        List<StopEntity> stopEntities = loadRouteInAndOutboundStop(routeEntities);

        logger.debug("Start calling [Stops from External API] from [List<StopEntity>]");
        loadAllStops();

        logger.debug("Finished fetching data from CTB");
        return fetchDataFromCTBResponseDto;
    }


}
