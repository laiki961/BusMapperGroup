package com.fsse.busmapper.domain.dto.internal.response.BusEta;

import com.fsse.busmapper.domain.BusEtaExtDO;
import com.fsse.busmapper.domain.BusEtaIntDO;
import com.fsse.busmapper.domain.entity.RouteStopEntity;
import com.fsse.busmapper.domain.entity.StopEntity;

public class BusEtaResponseDto {
    private String route;
    private String dir;

    private BusStopResponseDto stopsResponse;


    private BusOriResponseDto oriResponse;


    //need a constructor to construct itself from DO to dto, pass in the value from do into the method
    public BusEtaResponseDto(BusEtaIntDO busEtaIntDO) {
        this.route = busEtaIntDO.getRoute();
        this.dir = busEtaIntDO.getDir();
        this.stopsResponse.setSeq(busEtaIntDO.getStopSeq());
        this.stopsResponse.setStop(busEtaIntDO.getRouteStopId());
        this.stopsResponse.setName(busEtaIntDO.getStopName());
        this.stopsResponse.setLat(busEtaIntDO.getStopLat());
        this.stopsResponse.setLng(busEtaIntDO.getStopLng());
        this.oriResponse.setEstTimeStamp(busEtaIntDO.getEta());
        this.oriResponse.setStop(busEtaIntDO.getDestStop());
        //?
    }

//    public BusEtaIntDO toBusEtaDto(BusEtaExtDO busEtaExtDO){
//        //todo
//        // put stuff from do to dto
//        BusEtaIntDO busEtaIntDO = new BusEtaIntDO();
//        RouteStopEntity routeStopEntity = new RouteStopEntity();
//        StopEntity stopEntity = new StopEntity();
//
//        busEtaIntDO.setRoute(route);
//        busEtaIntDO.setDir(dir);
//        busEtaIntDO.setDestStop(destStop);
//
//        busEtaIntDO.setRouteStopEntity(routeStopEntity.getStopEntity().getStopId());
//        busEtaIntDO.setRouteStopEntity(routeStopEntity.getStopEntity().getLatitude());
//        busEtaIntDO.setRouteStopEntity(routeStopEntity.getStopEntity().getLongitude());
//        return busEtaIntDO;
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

    public BusStopResponseDto getStopsResponse() {
        return stopsResponse;
    }

    public void setStopsResponse(BusStopResponseDto stopsResponse) {
        this.stopsResponse = stopsResponse;
    }

    public BusOriResponseDto getOriResponse() {
        return oriResponse;
    }

    public void setOriResponse(BusOriResponseDto oriResponse) {
        this.oriResponse = oriResponse;
    }

    @Override
    public String toString() {
        return "BusEtaResponseDto{" +
                "route='" + route + '\'' +
                ", dir='" + dir + '\'' +
                ", stopsResponse=" + stopsResponse +
                ", oriResponse=" + oriResponse +
                '}';
    }
}
