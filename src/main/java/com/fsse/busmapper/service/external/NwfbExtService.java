package com.fsse.busmapper.service.external;

import com.fsse.busmapper.domain.dto.external.response.route.CtbRouteResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.routeStop.CtbRouteStopResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.stop.CtbStopResponseExtDto;

public interface NwfbExtService {
    CtbStopResponseExtDto getBusStopInfo(String stopId);
    CtbRouteStopResponseExtDto getRouteStopForSpecificBus(String route, String dir);
    CtbRouteResponseExtDto getBusOriNDest (String route);


}
