package com.fsse.busmapper.service.impl;

import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.Stop;
import com.fsse.busmapper.domain.entity.RouteEntity;
import com.fsse.busmapper.domain.entity.RouteStopEntity;
import com.fsse.busmapper.domain.entity.StopEntity;
import com.fsse.busmapper.repository.RouteRepository;
import com.fsse.busmapper.repository.RouteStopRepository;
import com.fsse.busmapper.repository.StopRepository;
import com.fsse.busmapper.service.NwfbService;
import com.fsse.busmapper.service.external.NwfbExtService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NwfbServiceImpl implements NwfbService {
    @Autowired
    private NwfbExtService nwfbExtService;
    @Autowired
    private StopRepository stopRepository;
    @Autowired
    private RouteStopRepository routeStopRepository;
    @Autowired
    private RouteRepository routeRepository;

    @Override
    public List<Stop> getBusStopInfo(String stopId) {
        List<Stop> stop = nwfbExtService.stop(stopId); //call ext API and return List<Stop> stopDo
        List<StopEntity> stopEntity = Stop.toStopEntity(); //V2 Do to Entity
        stopRepository.saveAll(stopEntity);
        return stop;
    }

    @Override
    public List<RouteStop> getRouteStopForSpecificBus(String route, String dir) {
        List<RouteStop> routeStop = nwfbExtService.routeStop(route,dir); //call ext API and return List<RouteStop> routeStopDo
        List<RouteStopEntity> routeStopEntity = RouteStop.toRouteStopEntity(routeStop);
        routeStopRepository.saveAll(routeStopEntity);
        return routeStop;
    }

    @Override
    public List<Route> getBusOrigAndDest() {
        List<Route> route = nwfbExtService.route();
        RouteEntity routeEntity = route.toRouteEntity();
        routeEntity = routeRepository.save(routeEntity);
        return route;
    }
}
