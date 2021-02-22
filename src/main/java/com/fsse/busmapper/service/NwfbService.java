package com.fsse.busmapper.service;

import com.fsse.busmapper.domain.dto.response.FetchDataFromCTBResponseDto;
import com.fsse.busmapper.domain.entity.RouteEntity;
import com.fsse.busmapper.domain.entity.RouteStopEntity;
import com.fsse.busmapper.domain.entity.StopEntity;

import java.util.List;

public interface NwfbService {
    FetchDataFromCTBResponseDto loadAllBusData(); //Final (not yet finished)

//    void loadAllRoutes(); //Don't touch ***
    List<RouteEntity> loadAllRoutes(); //Don't touch ***

//    void loadRouteInAndOutboundStop (List<RouteEntity> routeEntities); //Don't touch ***
//    void loadRouteDirectionStop(RouteEntity route, String dir); //Don't touch ***
//    List<StopEntity> loadRouteDirectionStop(RouteEntity route, String dir); //Don't touch***
    List<StopEntity> loadRouteInAndOutboundStop (List<RouteEntity> routeEntities); //Don't touch***
    List<RouteStopEntity> loadRouteDirectionStop(RouteEntity route, String dir); //Don't touch***
//    List<RouteStopEntity> loadRouteInAndOutboundStop (List<RouteEntity> routeEntities); //Don't touch***

//    List<RouteStopEntity> loadAllRouteStop(List<RouteEntity> routeEntities); // merge testing only

//   	void loadAllStops(List<RouteStopEntity> routeStops);
   	void loadAllStops();

}
