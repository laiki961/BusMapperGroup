package com.fsse.busmapper.domain;

public class LocationNameDOViewportSW {
    private Double lat;
    private Double lng;

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
        return "LocationNameDOViewportSW{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
