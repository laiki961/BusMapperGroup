package com.fsse.busmapper.domain;

public class LocationNameDO {
    private String formatName;
    private LocationNameDOGeometry geometry;
    public String placeId;

    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }

    public LocationNameDOGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(LocationNameDOGeometry geometry) {
        this.geometry = geometry;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    @Override
    public String toString() {
        return "LocationNameDO{" +
                "locationName='" + formatName + '\'' +
                ", geometry=" + geometry +
                ", placeId='" + placeId + '\'' +
                '}';
    }
}
