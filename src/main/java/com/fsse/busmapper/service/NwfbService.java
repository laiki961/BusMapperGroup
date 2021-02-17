package com.fsse.busmapper.service;

import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.Stop;

public interface NwfbService {
    Stop getBusStopInfo(String stopId);
    RouteStop getRouteStopForSpecificBus(String route, String dir);
    Route getBusOriNDest ();
}
