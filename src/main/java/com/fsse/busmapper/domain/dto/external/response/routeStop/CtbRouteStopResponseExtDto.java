package com.fsse.busmapper.domain.dto.external.response.routeStop;

import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.Stop;
import com.fsse.busmapper.domain.dto.external.response.route.CtbRouteDataResponseExtDto;

import java.util.ArrayList;
import java.util.List;

public class CtbRouteStopResponseExtDto {
    private String type;
    private List<CtbRouteStopDataResponseExtDto> data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<CtbRouteStopDataResponseExtDto> getData() {
        return data;
    }

    public void setData(List<CtbRouteStopDataResponseExtDto> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CtbRouteStopResponseExtDto{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }

    public List<RouteStop> toRouteStop(){
        List<RouteStop> routeStops = new ArrayList<>();

        for (int i=0;i<data.size();i++)
            CtbRouteDataResponseExtDto item = data.get(i);
            RouteStop routeStop = new RouteStop();
            routeStops.setCo(item.getCo());
            routeStops.setRouteId(routeStop.getRouteId());
            routeStops.setDir(routeStop.getDir());
            routeStops.setSeq(routeStop.getSeq());
            routeStops.setStopId(routeStop.getStopId());
        return routeStops;
    }
}
