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
        List<Stop> stop = nwfbExtService.stop(stopId);
        StopEntity stopEntity = stop.toStopEntity();
        stopEntity = stopRepository.save(stopEntity);
        return stop;
    }

    @Override
    public List<RouteStop> getRouteStopForSpecificBus(String route, String dir) {
        RouteStop routeStop = nwfbExtService.routeStop(route,dir);
        RouteStopEntity routeStopEntity = routeStop.toRouteStopEntity();
        routeStopEntity = routeStopRepository.save(routeStopEntity);
        return routeStop;
    }

    @Override
    public List<Route> getBusOriNDest() {
        Route route = nwfbExtService.route();
        RouteEntity routeEntity = route.toRouteEntity();
        routeEntity = routeRepository.save(routeEntity);
        return route;
    }
}
