package com.fsse.busmapper.service.external;

import com.fsse.busmapper.domain.BusEta;
import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.Stop;

import java.util.List;

public interface NwfbExtService {
    List<Route> loadAllRoutes();
    List<RouteStop> loadSpecificRouteStop(String route, String dir);
    Stop loadSpecificStop(String stopId);
    List<BusEta> loadEta(String stopId, String route);
    BusEta busArrivalEta(String stopId, String route);
}
