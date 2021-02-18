package com.fsse.busmapper.service;

import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.Stop;

import java.util.List;

public interface NwfbService {
    List<Stop> getBusStopInfo(String stopId);
    List<RouteStop> getRouteStopForSpecificBus(String route, String dir);
    List<Route> getBusOrigAndDest ();
}
