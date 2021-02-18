package com.fsse.busmapper.domain.dto.external.response.routeStop;

import com.fsse.busmapper.domain.RouteStop;

public class CtbRouteStopDataResponseExtDto {
    private String co;
    private String route;
    private String dir;
    private String stop;

    public RouteStop toRouteStopDO(){
        RouteStop routeStopDO = new RouteStop();
        routeStopDO.setCo(co);
        routeStopDO.setRoute(route);
        routeStopDO.setDir(dir);
        routeStopDO.setStop(stop);
        return routeStopDO;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    @Override
    public String toString() {
        return "CtbRouteStopDataResponseExtDto{" +
                "co='" + co + '\'' +
                ", route='" + route + '\'' +
                ", dir='" + dir + '\'' +
                ", stop=" + stop +
                '}';
    }
}
