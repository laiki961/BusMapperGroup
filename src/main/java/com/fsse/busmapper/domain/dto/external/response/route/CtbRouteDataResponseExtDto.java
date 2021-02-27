package com.fsse.busmapper.domain.dto.external.response.route;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse.busmapper.domain.Route;

public class CtbRouteDataResponseExtDto {
    private String co;
    private String route;
    @JsonProperty("orig_en")
    private String orig;
    @JsonProperty("dest_en")
    private String dest;


    public Route toRouteDO() {
        Route routeDo = new Route();
        routeDo.setRoute(route);
        routeDo.setCo(co);
        routeDo.setOrig(orig);
        routeDo.setDest(dest);
        return routeDo;
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

    public String getOrig() {
        return orig;
    }

    public void setOrig(String orig) {
        this.orig = orig;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    @Override
    public String toString() {
        return "CtbRouteDataResponseExtDto{" +
                "co='" + co + '\'' +
                ", route='" + route + '\'' +
                ", orig='" + orig + '\'' +
                ", dest='" + dest + '\'' +
                '}';
    }
}
