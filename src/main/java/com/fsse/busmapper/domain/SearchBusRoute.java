package com.fsse.busmapper.domain;

public class SearchBusRoute {
    private String co;
    private String route;
    private String direction;
    private String origName;
    private String origStop;
    private String destName;
    private String destStop;

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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getOrigName() {
        return origName;
    }

    public void setOrigName(String origName) {
        this.origName = origName;
    }

    public String getOrigStop() {
        return origStop;
    }

    public void setOrigStop(String origStop) {
        this.origStop = origStop;
    }

    public String getDestName() {
        return destName;
    }

    public void setDestName(String destName) {
        this.destName = destName;
    }

    public String getDestStop() {
        return destStop;
    }

    public void setDestStop(String destStop) {
        this.destStop = destStop;
    }

    @Override
    public String toString() {
        return "SearchBusRoute{" +
                "co='" + co + '\'' +
                ", route='" + route + '\'' +
                ", direction='" + direction + '\'' +
                ", origName='" + origName + '\'' +
                ", origStop='" + origStop + '\'' +
                ", destName='" + destName + '\'' +
                ", destStop='" + destStop + '\'' +
                '}';
    }
}
