package com.fsse.busmapper.service.external;

import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.Stop;
import com.fsse.busmapper.domain.dto.external.response.route.CtbRouteResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.routeStop.CtbRouteStopResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.stop.CtbStopResponseExtDto;
import com.fsse.busmapper.domain.entity.StopEntity;

public interface NwfbExtService {
    Stop stop(String stopId);
    RouteStop routeStop(String route, String dir);
    Route route(String route);

}
