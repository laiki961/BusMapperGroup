package com.fsse.busmapper.domain;

import com.fsse.busmapper.domain.dto.external.response.routeStop.CtbRouteStopDataResponseExtDto;
import com.fsse.busmapper.domain.entity.RouteStopEntity;
import com.fsse.busmapper.domain.entity.StopEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Stop {

    private String stopId;
    private String stopname;
    private Double latitude;
    private Double longitude;

//    //V1 DO to Entity (for loop留係Service)
//    public StopEntity toStopEntity() {
//        StopEntity stopEntity = new StopEntity();
//        stopEntity.setStopId(getStopId());
//        stopEntity.setStopname(getStopname());
//        stopEntity.setLatitude(getLatitude());
//        stopEntity.setLongitude(getLongitude());
//        return stopEntity;
//    }

    //V2 DO to Entity (要轉static 同埋掉 List<Stop> )
    public static List<StopEntity> toStopEntity(List<Stop> stop){
        List<StopEntity> stopEntities = new ArrayList<>();
        for(int i=0; i<stop.size(); i++) {
            StopEntity stopEntity = new StopEntity();
            stopEntity.setStopId(stop.get(i).getStopId());
            stopEntity.setStopname(stop.get(i).getStopname());
            stopEntity.setLatitude(stop.get(i).getLatitude());
            stopEntity.setLongitude(stop.get(i).getLongitude());
            stopEntities.add(stopEntity);
        }
        return stopEntities;
    }


    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getStopname() {
        return stopname;
    }

    public void setStopname(String stopname) {
        this.stopname = stopname;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Stop{" +
                "stopId='" + stopId + '\'' +
                ", stopname='" + stopname + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
