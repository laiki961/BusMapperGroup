package com.fsse.busmapper.service.impl;

import com.fsse.busmapper.api.LoggingApi;
import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.entity.RouteEntity;
import com.fsse.busmapper.domain.entity.RouteStopEntity;
import com.fsse.busmapper.domain.entity.StopEntity;
import com.fsse.busmapper.repository.RouteRepository;
import com.fsse.busmapper.repository.RouteStopRepository;
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

    Logger logger = LoggerFactory.getLogger(NwfbServiceImpl.class);

    @Override
    public void loadAllBusData(String route, String dir) {
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

    @Override
    public void testingRouteStopAPI(String route, String dir){
    // Step 2.0: Load RouteStop
    List<RouteStop> routeStopDOs = nwfbExtService.loadSpecificRouteStop(route, dir);
        logger.debug("A DEBUG Message101");
    // Step 2.1: Convert routeStopDO into Entity
    List<RouteStopEntity> routeStopEntities = new ArrayList<>();
        for (int i=0; i<routeStopDOs.size(); i++){
        logger.debug("A DEBUG Message102");
        RouteStopEntity entity = new RouteStopEntity();
        entity.setCo(routeStopDOs.get(i).getCo());
        entity.setDir(dir);

        RouteEntity routeE = new RouteEntity();
        routeE.setRouteId(routeRepository.findById());
        routeE.setOrig();
        routeE.setDest();

        entity.setSeq(routeStopDOs.get(i).getSeq());
        StopEntity stop = new StopEntity();
        stop.setStopId(routeStopDOs.get(i).getStop());
        stop.setStopname(null);
        stop.setLatitude(null);
        stop.setLongitude(null);
        entity.setStop(stop);
        routeStopEntities.add(entity);
        logger.debug(routeStopEntities.toString());
    }

    // Step 2.2: Save to database
        logger.debug("A DEBUG Message103");
        routeStopRepository.saveAll(routeStopEntities);
    }




}
