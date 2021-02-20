package com.fsse.busmapper.service;

import com.fsse.busmapper.domain.dto.response.FetchDataFromCTBResponseDto;
import com.fsse.busmapper.domain.entity.RouteEntity;
import com.fsse.busmapper.domain.entity.RouteStopEntity;

import java.util.List;

public interface NwfbService {
//    FetchDataFromCTBResponseDto loadAllBusData(); //Final (not yet finished)

    void loadAllRoutes(); //Don't touch ***
//    List<RouteEntity> loadAllRoutes();

    void loadRouteInAndOutboundStop (List<RouteEntity> routeEntities); //Don't touch
    void loadRouteDirectionStop(RouteEntity route, String dir); //Don't touch
//    List<RouteStopEntity> loadRouteInAndOutboundStop (List<RouteEntity> routeEntities);

   	void loadAllStops(List<RouteStopEntity> routeStops);
}
