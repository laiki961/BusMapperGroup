package com.fsse.busmapper.service;

import com.fsse.busmapper.domain.entity.RouteEntity;

import java.util.List;

public interface NwfbService {
    void loadAllBusData(); //Final (not yet finished)

    void loadAllRoutes(); //Don't touch ***

    void loadRouteDirectionStop(RouteEntity route, String dir); //Don't touch
    void loadRouteInAndOutboundStop (List<RouteEntity> routeEntities); //Doing this
}
