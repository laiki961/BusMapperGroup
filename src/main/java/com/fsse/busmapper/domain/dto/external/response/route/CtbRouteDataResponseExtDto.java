package com.fsse.busmapper.domain.dto.external.response.route;

public class CtbRouteDataResponseExtDto {
    private String co;
    private String route;
    private String orig_en;
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

    public String getOrig_en() {
        return orig_en;
    }

    public void setOrig_en(String orig_en) {
        this.orig_en = orig_en;
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
                ", orig_en='" + orig_en + '\'' +
                ", dest_en='" + dest_en + '\'' +
                '}';
    }
}
