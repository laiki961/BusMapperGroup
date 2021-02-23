package com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceNameResponseExtDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse.busmapper.domain.LocationNameDO;
import com.fsse.busmapper.domain.LocationNameDOGeometry;

public class GoogleSearchPlaceNameResponseExtDtoResultGeometry {
    private GoogleSearchPlaceNameResponseExtDtoResultGeometryLocation location;
    private GooglSearchPlaceNameResponseExtDtoResultGeometryViewport viewport;

    public GoogleSearchPlaceNameResponseExtDtoResultGeometryLocation getLocation() {
        return location;
    }

    public void setLocation(GoogleSearchPlaceNameResponseExtDtoResultGeometryLocation location) {
        this.location = location;
    }

    public GooglSearchPlaceNameResponseExtDtoResultGeometryViewport getViewport() {
        return viewport;
    }

    public void setViewport(GooglSearchPlaceNameResponseExtDtoResultGeometryViewport viewport) {
        this.viewport = viewport;
    }
    public LocationNameDOGeometry toLocationNameDOGeometry(){
        LocationNameDOGeometry locationNameDOGeometry = new LocationNameDOGeometry();
        locationNameDOGeometry.setLocation(locationNameDOGeometry.getLocation());
        locationNameDOGeometry.setViewport(locationNameDOGeometry.getViewport());
        return locationNameDOGeometry;
    }

}
