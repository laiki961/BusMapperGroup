package com.fsse.busmapper.domain;

import com.fsse.busmapper.domain.dto.internal.response.BusEta.BusEtaResponseDto;
import com.fsse.busmapper.domain.entity.RouteStopEntity;
import com.fsse.busmapper.domain.entity.StopEntity;
import com.fsse.busmapper.service.NwfbService;

public class BusEtaIntDO {

    private String route;
    private String dir;
    private String oriStop;
    private String destStop;

    private Integer stopSeq;
    private Integer routeStopId;
    private String stopName;
    private Double stopLat;
    private Double stopLng;

    private String eta;

    toBusEtaResponseDto()

    public BusEtaIntDO(BusEtaExtDO result, RouteStopEntity routeStopEntity, StopEntity stopEntity){
        this.route = result.ge;
        this.dir = routeStopEntity.getDir();
        this.stopSeq = routeStopEntity.getSeq();
        this.routeStopId = routeStopEntity.getRouteStopId();
        this.stopName = stopEntity.getStopname();
        this.stopLat = stopEntity.getLatitude();
        this.stopLng = stopEntity.getLongitude();
        this.oriStop = result.getClass();
        this.destStop = result.g;
        this.eta = result.getEta();
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

    public String getOriStop() {
        return oriStop;
    }

    public void setOriStop(String oriStop) {
        this.oriStop = oriStop;
    }

    public String getDestStop() {
        return destStop;
    }

    public void setDestStop(String destStop) {
        this.destStop = destStop;
    }

    public String getStopSeq() {
        return stopSeq;
    }

    public void setStopSeq(String stopSeq) {
        this.stopSeq = stopSeq;
    }

    public String getRouteStopId() {
        return routeStopId;
    }

    public void setRouteStopId(String routeStopId) {
        this.routeStopId = routeStopId;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public Double getStopLat() {
        return stopLat;
    }

    public void setStopLat(Double stopLat) {
        this.stopLat = stopLat;
    }

    public Double getStopLng() {
        return stopLng;
    }

    public void setStopLng(Double stopLng) {
        this.stopLng = stopLng;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "BusEtaIntDO{" +
                "route='" + route + '\'' +
                ", dir='" + dir + '\'' +
                ", oriStop='" + oriStop + '\'' +
                ", destStop='" + destStop + '\'' +
                ", stopSeq='" + stopSeq + '\'' +
                ", routeStopId='" + routeStopId + '\'' +
                ", stopName='" + stopName + '\'' +
                ", stopLat=" + stopLat +
                ", stopLng=" + stopLng +
                ", eta='" + eta + '\'' +
                '}';
    }
}

