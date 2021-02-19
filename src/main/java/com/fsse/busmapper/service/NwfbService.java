package com.fsse.busmapper.service;

public interface NwfbService {
    //load all bus data
    void loadAllBusData(String route, String dir);
    void testingRouteStopAPI(String route, String dir);
}
