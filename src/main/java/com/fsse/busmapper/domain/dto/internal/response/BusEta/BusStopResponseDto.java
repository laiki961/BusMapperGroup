package com.fsse.busmapper.domain.dto.internal.response.BusEta;

public class BusStopResponseDto {
    private String seq;
    private String stop;
    private String name;
    private Double lat;
    private Double lng;

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "BusStopResponseDto{" +
                "seq='" + seq + '\'' +
                ", stop='" + stop + '\'' +
                ", name='" + name + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
