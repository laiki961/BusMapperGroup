package com.fsse.busmapper.service.external.impl;

import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.Stop;
import com.fsse.busmapper.domain.dto.external.response.route.CtbRouteResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.routeStop.CtbRouteStopResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.stop.CtbStopResponseExtDto;
import com.fsse.busmapper.service.external.NwfbExtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NwfbExtServiceImpl implements NwfbExtService {
    // Use this in this class only!!!!!
    @Autowired
    @Qualifier("nwfbRestTemplate")
    private RestTemplate restTemplate;

    @Override
    public List<Stop> stop(String stopId){
        CtbStopResponseExtDto responseExtDto = getBusStopInfo(stopId); //call Ext API
        return responseExtDto.toStopDo(); //Dto to Do
    }

    @Override
    public List<RouteStop> routeStop(String route, String dir){
        CtbRouteStopResponseExtDto responseExtDto = getRouteStopForSpecificBus(route, dir);
        return responseExtDto.toRouteStopDo();
    }

    @Override
    public List<Route> route(){
        CtbRouteResponseExtDto responseExtDto = getBusOrigAndDest();
        return responseExtDto.toRouteDo();
    }

    private CtbStopResponseExtDto getBusStopInfo(String stopId) {
        CtbStopResponseExtDto responseExtDto = restTemplate.getForObject(
                "https://rt.data.gov.hk/" +
                        "v1/transport/citybus-nwfb/stop/" + stopId,
                CtbStopResponseExtDto.class
        );
        return responseExtDto;
    }

    private CtbRouteStopResponseExtDto getRouteStopForSpecificBus(String route, String dir) {
        CtbRouteStopResponseExtDto responseExtDto = restTemplate.getForObject(
                "https://rt.data.gov.hk/" +
                "v1/transport/citybus-nwfb/route-stop/CTB/" + route + "/" + dir,
                CtbRouteStopResponseExtDto.class
        );
        return responseExtDto;
    }

    private CtbRouteResponseExtDto getBusOrigAndDest() {
        CtbRouteResponseExtDto responseExtDto = restTemplate.getForObject(
                "https://rt.data.gov.hk/v1/transport/citybus-nwfb/route/ctb",
                CtbRouteResponseExtDto.class
        );
        return responseExtDto;
    }






}
