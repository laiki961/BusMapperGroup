package com.fsse.busmapper.service.impl;

import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.entity.RouteEntity;
import com.fsse.busmapper.domain.entity.RouteStopEntity;
import com.fsse.busmapper.repository.RouteRepository;
import com.fsse.busmapper.repository.RouteStopRepository;
import com.fsse.busmapper.service.NwfbService;
import com.fsse.busmapper.service.external.NwfbExtService;
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

        // Step 2.0: Load RouteStop
        List<RouteStop> routeStopDOs = nwfbExtService.loadSpecificRouteStop(route, dir);
        // Step 2.1: Convert routeStopDO into Entity
        List<RouteStopEntity> routeStopEntities = new ArrayList<>();
        for (int i=0; i<routeStopDOs.size(); i++){
            RouteStopEntity entity = new RouteStopEntity();
            entity.setCo(routeStopDOs.get(i).getCo());
            entity.setDir(routeStopDOs.get(i).getDir());
            entity.setSeq(routeStopDOs.get(i).getSeq());
            routeStopEntities.add(entity);
        }
        // Step 2.2: Save to database
        routeStopRepository.saveAll(routeStopEntities);

    }
}
