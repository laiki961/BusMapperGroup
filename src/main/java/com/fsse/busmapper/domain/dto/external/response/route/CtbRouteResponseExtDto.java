package com.fsse.busmapper.domain.dto.external.response.route;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.Stop;

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

    public List<Route> toRouteDo(){
        List<Route> routeDo = new ArrayList<>();
        for(int i=0; i<data.size(); i++) {
            CtbRouteDataResponseExtDto item = data.get(i);
            Route route = new Route();
            route.setRouteId(item.getRoute());
            route.setCo(item.getCo());
            route.setOrig(item.getOrig_en());
            route.setDest(item.getDest_en());
            routeDo.add(route);
        }
        return routeDo;
    }


}
