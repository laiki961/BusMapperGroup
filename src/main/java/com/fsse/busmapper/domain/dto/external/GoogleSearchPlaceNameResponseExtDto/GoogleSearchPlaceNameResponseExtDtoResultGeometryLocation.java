package com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceNameResponseExtDto;

public class GoogleSearchPlaceNameResponseExtDtoResultGeometryLocation {
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
        return "GoogleSearchPlaceNameResponseExtDtoResultGeometryLocation{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }
//    public LocationNameDOGeometryLocation toLocationNameDOGeometryLocation(){
//        LocationNameDOGeometryLocation locationNameDOGeometryLocation = new LocationNameDOGeometryLocation();
//        locationNameDOGeometryLocation.setLat(lat);
//        locationNameDOGeometryLocation.setLng(lng);
//        return locationNameDOGeometryLocation;
//    }
}
