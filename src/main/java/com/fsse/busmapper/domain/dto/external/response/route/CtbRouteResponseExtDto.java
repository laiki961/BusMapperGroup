package com.fsse.busmapper.domain.dto.external.response.route;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fsse.busmapper.domain.Route;

import java.util.ArrayList;
import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class CtbRouteResponseExtDto {
    private List<CtbRouteDataResponseExtDto> data;

    public List<Route> toRoutesDO() {
        List<Route> routeDOs = new ArrayList<>();
        for(int i=0; i<data.size(); i++) {
            CtbRouteDataResponseExtDto routeDto = data.get(i);
            routeDOs.add(routeDto.toRouteDO());
        }
        return routeDOs;
    }

    public List<CtbRouteDataResponseExtDto> getData() {
        return data;
    }

    public void setData(List<CtbRouteDataResponseExtDto> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CtbRouteResponseExtDto{" +
                "data=" + data +
                '}';
    }
}
