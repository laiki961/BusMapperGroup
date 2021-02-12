package com.fsse.busmapper.domain.dto.external.response.stop;

public class CtbStopDataResponseExtDto {
    private String stop;
    private String name_en;
    private String lat;
    private String lon;

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

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "CtbStopDataResponseExtDto{" +
                "stop='" + stop + '\'' +
                ", name_en='" + name_en + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                '}';
    }
}
