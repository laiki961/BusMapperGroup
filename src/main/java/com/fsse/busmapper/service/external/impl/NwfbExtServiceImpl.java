package com.fsse.busmapper.service.external.impl;

import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.dto.external.response.route.CtbRouteDataResponseExtDto;
import com.fsse.busmapper.domain.dto.external.response.route.CtbRouteResponseExtDto;
import com.fsse.busmapper.service.external.NwfbExtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class NwfbExtServiceImpl implements NwfbExtService {
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
}
