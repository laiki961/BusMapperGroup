package com.fsse.busmapper.service;

import com.fsse.busmapper.domain.BusEta;
import com.fsse.busmapper.domain.dto.internal.response.bus.FetchDataFromCTBResponseDto;
import com.fsse.busmapper.domain.entity.RouteEntity;
import com.fsse.busmapper.domain.entity.RouteStopEntity;
import com.fsse.busmapper.domain.entity.StopEntity;

import java.util.List;

public interface NwfbService {
    //Final
    FetchDataFromCTBResponseDto loadAllBusData();

//    void loadAllRoutes(); //Don't touch ***
    List<RouteEntity> loadAllRoutes(); //Don't touch ***

//    void loadRouteInAndOutboundStop (List<RouteEntity> routeEntities); //Don't touch ***
//    void loadRouteDirectionStop(RouteEntity route, String dir); //Don't touch ***
    List<StopEntity> loadRouteInAndOutboundStop (List<RouteEntity> routeEntities); //Don't touch***
    List<RouteStopEntity> loadRouteDirectionStop(RouteEntity route, String dir); //Don't touch***

   	void loadAllStops();
    BusEta busArrivalEta(String dir, String seq);
}
