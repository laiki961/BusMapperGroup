package com.fsse.busmapper.domain.dto.external.response.BusEta;

import java.util.List;

public class BusEtaResponseExtDto {
    private List<BusEtaDataResponseExtDto> data;
    private String route;
    
    private String dir;
    private String oriStop;
    private String destStop;

    private BusEtaResponseExtDto stops;
    private BusEtaResponseExtDto origin;


//    public BusEtaIntDO toBusEtaDto(){
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


    public List<BusEtaDataResponseExtDto> getData() {
        return data;
    }

    public void setData(List<BusEtaDataResponseExtDto> data) {
        this.data = data;
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

    public BusEtaResponseExtDto getStops() {
        return stops;
    }

    public void setStops(BusEtaResponseExtDto stops) {
        this.stops = stops;
    }

    public BusEtaResponseExtDto getOrigin() {
        return origin;
    }

    public void setOrigin(BusEtaResponseExtDto origin) {
        this.origin = origin;
    }

    public String getDestStop() {
        return destStop;
    }

    public void setDestStop(String destStop) {
        this.destStop = destStop;
    }

    @Override
    public String toString() {
        return "BusEtaResponseDto{" +
                "data=" + data +
                ", route='" + route + '\'' +
                ", dir='" + dir + '\'' +
                ", stops=" + stops +
                ", origin=" + origin +
                ", destStop='" + destStop + '\'' +
                '}';
    }

}
