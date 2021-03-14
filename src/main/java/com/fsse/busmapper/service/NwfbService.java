package com.fsse.busmapper.service;

import com.fsse.busmapper.domain.EstTime;
import com.fsse.busmapper.domain.dto.internal.response.bus.FetchDataFromCTBResponseDto;
import com.fsse.busmapper.domain.entity.RouteEntity;
import com.fsse.busmapper.domain.entity.RouteStopEntity;
import com.fsse.busmapper.domain.entity.StopEntity;

import java.util.List;

public interface NwfbService {
    //Final
    FetchDataFromCTBResponseDto loadAllBusData();

    List<RouteEntity> loadAllRoutes(); //Don't touch ***

    List<StopEntity> loadRouteInAndOutboundStop (List<RouteEntity> routeEntities); //Don't touch***
    List<RouteStopEntity> loadRouteDirectionStop(RouteEntity route, String dir); //Don't touch***

   	void loadAllStops();

   	////////////
    List<StopEntity> stopEntityList(String routeId, String direction);

    List<RouteStopEntity> routeStopEntities(String routeId, String direction);

    EstTime loadEstTime(String routeId, String origStopId);
}
