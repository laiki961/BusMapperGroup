package com.fsse.busmapper.domain.dto.external.response.route;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse.busmapper.domain.Route;

import java.util.ArrayList;
import java.util.List;

public class CtbRouteResponseExtDto {
    private String type;
    private List<CtbRouteDataResponseExtDto> data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }

    public Route toRoute(){
        Route route = new Route();
        route.setCo(route.getCo());
        route.setRouteId(route.getRouteId());
        route.setOrig(route.getOrig());
        route.setDest(route.getDest());
        return route;
    }
}
