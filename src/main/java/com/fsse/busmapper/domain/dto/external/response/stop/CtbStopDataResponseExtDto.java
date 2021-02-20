package com.fsse.busmapper.domain.dto.external.response.stop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.Stop;

public class CtbStopDataResponseExtDto {
    @JsonProperty("stop")
    private String stopId;
    @JsonProperty("name_en")
    private String stopName;
    private Double lat;
    @JsonProperty("long")
    private Double lng;

    public Stop toStopDO() {
        Stop stopDo = new Stop();
        stopDo.setStopId(stopId);
        stopDo.setStopName(stopName);
        stopDo.setLat(lat);
        stopDo.setLng(lng);
        return stopDo;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "CtbStopResponseExtDto{" +
                "stopId='" + stopId + '\'' +
                ", stopName='" + stopName + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
