package com.fsse.busmapper.service.external.impl;

import com.fsse.busmapper.api.DebugApi;
import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.Stop;
import com.fsse.busmapper.domain.dto.external.response.route.CtbRouteDataResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.route.CtbRouteResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.stop.CtbStopResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.routeStop.CtbRouteStopResponseExtDto;
import com.fsse.busmapper.domain.entity.StopEntity;
import com.fsse.busmapper.service.external.NwfbExtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class NwfbExtServiceImpl implements NwfbExtService {
    private Logger logger = LoggerFactory.getLogger(NwfbExtServiceImpl.class);

    // Use this in this class only!!!!!
    @Autowired
    @Qualifier("nwfbRestTemplate")
    private RestTemplate restTemplate;

    @Override
    public List<Route> loadAllRoutes() {
        CtbRouteResponseExtDto response = restTemplate.getForObject(
                "https://rt.data.gov.hk/" +
                        "v1/transport/citybus-nwfb/route/CTB/",
                CtbRouteResponseExtDto.class
        );

        List<Route> routeDOs = new ArrayList<>();
        for(int i=0; i<response.getData().size(); i++) {
            CtbRouteDataResponseExtDto routeDto = response.getData().get(i);
            routeDOs.add(routeDto.toRouteDO());
        }
        return routeDOs;
    }
    
	@Override
    public List<RouteStop> loadSpecificRouteStop(String route, String dir){
        CtbRouteStopResponseExtDto response = restTemplate.getForObject(
                "https://rt.data.gov.hk/" +
                        "v1/transport/citybus-nwfb/route-stop/CTB/" + route + "/" + dir,
                CtbRouteStopResponseExtDto.class
        );

         List<RouteStop> routeStopDOs = new ArrayList<>();
         for(int i=0; i<response.getData().size(); i++){
             routeStopDOs.add(response.getData().get(i).toRouteStopDO());
         }
         return routeStopDOs;
    }

    @Override
    public List<Stop> loadAllStops(String stopId) {
        CtbStopResponseExtDto response = restTemplate.getForObject(
                "https://rt.data.gov.hk/" +
                        "v1/transport/citybus-nwfb/stop/" + stopId,
                CtbStopResponseExtDto.class
        );

        List<Stop> stopDOs = new ArrayList<>();
        Stop stop = new Stop();
        logger.debug("stopID {}: Adding Stop's elements to [StopDO] ", stopId);
        stop.setStopName(response.getData().getStopName());
        stop.setLat(response.getData().getLat());
        stop.setLng(response.getData().getLng());
        stopDOs.add(stop);
        logger.debug("stopID {}: Added [StopDO] details into [List<Stop>]", stopId);
        return stopDOs;
    }


}
