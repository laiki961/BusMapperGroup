package com.fsse.busmapper.domain;

public class Route {
    private String co;
    private String route;
    private String orig;
    private String dest;

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
        return "Route{" +
                "co='" + co + '\'' +
                ", route='" + route + '\'' +
                ", orig='" + orig + '\'' +
                ", dest='" + dest + '\'' +
                '}';
    }
}
