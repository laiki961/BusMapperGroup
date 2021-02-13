package com.fsse.busmapper.domain.dto.external.response.stop;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CtbStopDataResponseExtDto {
    private String stop;
    private String name_en;
    @JsonProperty("lat")
    private String lat;
    @JsonProperty("long")
    private String longitude;

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

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
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
