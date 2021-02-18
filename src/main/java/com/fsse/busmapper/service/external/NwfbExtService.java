package com.fsse.busmapper.service.external;

import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.RouteStop;

import java.util.List;

public interface NwfbExtService {
    List<Route> loadAllRoutes();
    List<RouteStop> loadSpecificRouteStop(String route, String dir);
}
