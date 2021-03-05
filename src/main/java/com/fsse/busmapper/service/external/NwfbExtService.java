package com.fsse.busmapper.service.external;

import com.fsse.busmapper.domain.*;
import com.fsse.busmapper.domain.dto.external.response.BusEta.BusEtaResponseExtDto;

import java.util.List;

public interface NwfbExtService {
    List<Route> loadAllRoutes();
    List<RouteStop> loadSpecificRouteStop(String route, String dir);
    Stop loadSpecificStop(String stopId);
    BusEtaExtDO busEta(String oriStop, String route);
}
