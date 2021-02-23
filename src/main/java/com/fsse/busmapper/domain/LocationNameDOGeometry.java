package com.fsse.busmapper.domain;

public class LocationNameDOGeometry {
    private LocationNameDOGeometryLocation location;
    private LocationNameDOGeometryViewport viewport;

    public LocationNameDOGeometryLocation getLocation() {
        return location;
    }

    public void setLocation(LocationNameDOGeometryLocation location) {
        this.location = location;
    }

    public LocationNameDOGeometryViewport getViewport() {
        return viewport;
    }

    public void setViewport(LocationNameDOGeometryViewport viewport) {
        this.viewport = viewport;
    }

    @Override
    public String toString() {
        return "LocationNameDOGeometry{" +
                "location=" + location +
                ", viewport=" + viewport +
                '}';
    }
}
