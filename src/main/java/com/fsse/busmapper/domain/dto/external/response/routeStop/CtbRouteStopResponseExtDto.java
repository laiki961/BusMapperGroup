package com.fsse.busmapper.domain.dto.external.response.routeStop;

import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.Stop;

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

    public RouteStop toRouteStop(){
        RouteStop routeStop = new RouteStop();
        routeStop.setCo(routeStop.getCo());
        routeStop.setRouteId(routeStop.getRouteId());
        routeStop.setDir(routeStop.getDir());
        routeStop.setSeq(routeStop.getSeq());
        routeStop.setStopId(routeStop.getStopId());
        return routeStop;
    }
}
