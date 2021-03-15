package com.fsse.busmapper.service.external.impl;

import com.fsse.busmapper.domain.EstTime;
import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.Stop;
import com.fsse.busmapper.domain.dto.external.response.estTime.CtbEstTimeResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.route.CtbRouteDataResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.route.CtbRouteResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.routeStop.CtbRouteStopResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.stop.CtbStopResponseExtDto;
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
    public Stop loadSpecificStop(String stopId) {
        CtbStopResponseExtDto response = restTemplate.getForObject(
                "https://rt.data.gov.hk/" +
                        "v1/transport/citybus-nwfb/stop/" + stopId,
                CtbStopResponseExtDto.class
        );

            logger.debug("stopID {}: Adding Stop's elements to [StopDO]", stopId);
            Stop stopDO = response.toStop();
            logger.debug("stopID {}: Added [StopDO] into [List<Stop>]", stopId);
        return stopDO;
    }

    @Override
    public CtbEstTimeResponseExtDto loadEstTime(String origStopId, String routeId) {
        CtbEstTimeResponseExtDto response = restTemplate.getForObject(
                "https://rt.data.gov.hk/v1/transport/citybus-nwfb/eta/CTB/" + origStopId  + "/" + routeId,
                CtbEstTimeResponseExtDto.class);
        return response;

    }


}
