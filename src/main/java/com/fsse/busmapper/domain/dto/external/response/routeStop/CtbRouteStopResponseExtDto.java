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

    public List<RouteStop> toRouteStopDo(){
        List<RouteStop> routeStopDo = new ArrayList<>();
        for(int i=0; i<data.size(); i++) {
            CtbRouteStopDataResponseExtDto item = data.get(i);
            RouteStop routeStop = new RouteStop();
            routeStop.setCo(item.getCo());
            routeStop.setRouteId(item.getRoute());
            routeStop.setDir(item.getDir());
            routeStop.setSeq(item.getSeq());
            routeStop.setStopId(item.getStop());
            routeStopDo.add(routeStop);
        }
        return routeStopDo;
    }
}
