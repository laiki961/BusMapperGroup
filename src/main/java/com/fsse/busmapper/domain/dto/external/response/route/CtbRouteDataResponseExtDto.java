package com.fsse.busmapper.domain.dto.external.response.route;

public class CtbRouteDataResponseExtDto {
    private String co;
    private String route;
    private String dest_en;

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

    public String getDest_en() {
        return dest_en;
    }

    public void setDest_en(String dest_en) {
        this.dest_en = dest_en;
    }

    @Override
    public String toString() {
        return "CtbRouteDataResponseExtDto{" +
                "co='" + co + '\'' +
                ", route='" + route + '\'' +
                ", dest_en='" + dest_en + '\'' +
                '}';
    }
}
