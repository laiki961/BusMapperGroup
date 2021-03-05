package com.fsse.busmapper.service.external;

import com.fsse.busmapper.domain.Eta;
import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.Stop;
import com.fsse.busmapper.domain.dto.external.response.eta.CtbEtaResponseExtDto;

import java.util.List;

public interface NwfbExtService {
    List<Route> loadAllRoutes();
    List<RouteStop> loadSpecificRouteStop(String route, String dir);
    Stop loadSpecificStop(String stopId);
    Eta busRouteDetailsWithOriginEta(Integer stopId, Integer route);
}
