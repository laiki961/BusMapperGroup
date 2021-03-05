package com.fsse.busmapper.service.external;

import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.Stop;
import com.fsse.busmapper.domain.dto.external.response.estTime.CtbEstTimeResponseExtDto;

import java.util.List;

public interface NwfbExtService {
    List<Route> loadAllRoutes();
    List<RouteStop> loadSpecificRouteStop(String route, String dir);
    Stop loadSpecificStop(String stopId);
    CtbEstTimeResponseExtDto loadEstTime(String origStopId, String routeId);
}
