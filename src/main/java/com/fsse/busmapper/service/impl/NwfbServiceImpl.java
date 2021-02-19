package com.fsse.busmapper.service.impl;

import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.Stop;
import com.fsse.busmapper.domain.entity.RouteEntity;
import com.fsse.busmapper.domain.entity.StopEntity;
import com.fsse.busmapper.repository.RouteRepository;
import com.fsse.busmapper.repository.StopRepository;
import com.fsse.busmapper.service.NwfbService;
import com.fsse.busmapper.service.external.NwfbExtService;
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
    private StopRepository stopRepository;

    @Override
    public void loadAllBusData() {
        // Step 1: Load all routes
        List<Route> routeDOs = nwfbExtService.loadAllRoutes();

        // Step 2: Convert the routeDO into RouteEntity
        List<RouteEntity> routeEntities = new ArrayList<>();
        for (int i = 0; i < routeDOs.size(); i++) {
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

    @Override
    public void loadStop(String stopId) {
        Stop stops = nwfbExtService.stop(stopId);
        StopEntity stopEntity = new StopEntity();

        stopEntity.setStopId((stops.getStopId()));
        stopEntity.setStopName(stops.getStopName());
        stopEntity.setLat(stops.getLat());
        stopEntity.setLng(stops.getLng());
        stops.setStopId(stopEntity.getStopId());

        stopEntity = stopRepository.save(stopEntity);
    }
}
