package com.fsse.busmapper.service.external;

import com.fsse.busmapper.domain.Route;

import java.util.List;

public interface NwfbExtService {
    List<Route> loadAllRoutes();
}
