package com.fsse.busmapper.service.external.impl;

import com.fsse.busmapper.domain.dto.external.response.route.CtbRouteResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.routeStop.CtbRouteStopResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.stop.CtbStopResponseExtDto;
import com.fsse.busmapper.service.external.NwfbExtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NwfbExtServiceImpl implements NwfbExtService {
    // Use this in this class only!!!!!
    @Autowired
    @Qualifier("nwfbRestTemplate")
    private RestTemplate restTemplate;

    @Override
    public CtbStopResponseExtDto getBusStopInfo(String stopId) {
        CtbStopResponseExtDto responseExtDto = restTemplate.getForObject(
                "https://rt.data.gov.hk/" +
                        "v1/transport/citybus-nwfb/stop/" + stopId,
                CtbStopResponseExtDto.class
        );
        return responseExtDto;
    }

    @Override
    public CtbRouteStopResponseExtDto getRouteStopForSpecificBus(String route, String dir) {
        CtbRouteStopResponseExtDto responseExtDto = restTemplate.getForObject(
                "https://rt.data.gov.hk/" +
                "v1/transport/citybus-nwfb/routestop/CTB" + route + dir,
                CtbRouteStopResponseExtDto.class
        );
        return responseExtDto;
    }

    @Override
    public CtbRouteResponseExtDto getBusOriNDest(String route) {
        CtbRouteResponseExtDto responseExtDto = restTemplate.getForObject(
                "https://rt.data.gov.hk/" +
                        "v1/transport/citybusnwfb/route/CTB/" + route,
                CtbRouteResponseExtDto.class
        );
        return responseExtDto;
    }
}
