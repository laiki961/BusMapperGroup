package com.fsse.busmapper.service.external;

import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.Stop;
import com.fsse.busmapper.domain.dto.external.response.route.CtbStopResponseExtDto;

import java.util.List;

public interface NwfbExtService {
    List<Route> loadAllRoutes();

    Stop stop(String stopId);

}
