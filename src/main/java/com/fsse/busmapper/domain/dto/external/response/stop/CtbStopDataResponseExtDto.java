package com.fsse.busmapper.domain.dto.external.response.stop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse.busmapper.domain.Stop;

public class CtbStopDataResponseExtDto {
    private String stop;
    private String name_en;
    @JsonProperty("lat")
    private Double lat;
    @JsonProperty("long")
    private Double longitude;

    public CtbStopDataResponseExtDto() {}

    public CtbStopDataResponseExtDto(Stop stop) {
        this.stop = stop.getStopId();
        this.name_en = stop.getStopname();
        this.lat = stop.getLatitude();
        this.longitude = stop.getLongitude();
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }


    @Override
    public String toString() {
        return "CtbStopDataResponseExtDto{" +
                "stop='" + stop + '\'' +
                ", name_en='" + name_en + '\'' +
                ", latitude='" + lat + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
