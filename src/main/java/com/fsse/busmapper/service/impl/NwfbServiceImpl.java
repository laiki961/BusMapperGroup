package com.fsse.busmapper.service.impl;

import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.entity.RouteEntity;
import com.fsse.busmapper.repository.RouteRepository;
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

    @Override
    public void loadAllBusData() {
        // Step 1: Load all routes
        List<Route> routeDOs = nwfbExtService.loadAllRoutes();

        // Step 2: Convert the routeDO into RouteEntity
        List<RouteEntity> routeEntities = new ArrayList<>();
        for(int i=0; i<routeDOs.size(); i++) {
            Route routeDO = routeDOs.get(i);
            RouteEntity entity = new RouteEntity();
            entity.setRouteId(routeDO.getRoute());
            entity.setOrig(routeDO.getOrig());
            entity.setDest(routeDO.getDest());
            routeEntities.add(entity);
        }

        // Step 3: Save all RouteEntity to database
        routeRepository.saveAll(routeEntities);

        // ...
    }
}
