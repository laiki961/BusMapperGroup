package com.fsse.busmapper.domain.dto.internal.response.BusEta;

public class BusEtaResponseDto {
    private String route;
    private String dir;
    private BusStopResponseDto stops;
    private BusOriResponseDto origin;
    private String desStop;

//    public void toBusEtaDto(String route, String dir, String oriStop, String destStop){
//
//    }

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

    public BusStopResponseDto getStops() {
        return stops;
    }

    public void setStops(BusStopResponseDto stops) {
        this.stops = stops;
    }

    public BusOriResponseDto getOrigin() {
        return origin;
    }

    public void setOrigin(BusOriResponseDto origin) {
        this.origin = origin;
    }

    public String getDesStop() {
        return desStop;
    }

    public void setDesStop(String desStop) {
        this.desStop = desStop;
    }

    @Override
    public String toString() {
        return "BusEtaResponseDto{" +
                "route='" + route + '\'' +
                ", dir='" + dir + '\'' +
                ", stops=" + stops +
                ", origin=" + origin +
                ", desStop='" + desStop + '\'' +
                '}';
    }
}
