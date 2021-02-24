package com.fsse.busmapper.domain.dto.internal.response.place;

public class SearchBusRouteResponseDto {
    private String co;
    private String route;
    private String direction;
    private String origName;
    private Integer origStop;
    private String destName;
    private Integer destStop;

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

    public Integer getOrigStop() {
        return origStop;
    }

    public void setOrigStop(Integer origStop) {
        this.origStop = origStop;
    }

    public String getDestName() {
        return destName;
    }

    public void setDestName(String destName) {
        this.destName = destName;
    }

    public Integer getDestStop() {
        return destStop;
    }

    public void setDestStop(Integer destStop) {
        this.destStop = destStop;
    }

    @Override
    public String toString() {
        return "SearchBusRouteResponse{" +
                "co='" + co + '\'' +
                ", route='" + route + '\'' +
                ", direction='" + direction + '\'' +
                ", origName='" + origName + '\'' +
                ", origStop=" + origStop +
                ", destName='" + destName + '\'' +
                ", destStop=" + destStop +
                '}';
    }
}
