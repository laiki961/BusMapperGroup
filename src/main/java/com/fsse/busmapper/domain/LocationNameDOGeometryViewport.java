package com.fsse.busmapper.domain;

public class LocationNameDOGeometryViewport {
    private LocationNameDOViewportNE ne;
    private LocationNameDOViewportSW sw;

    public LocationNameDOViewportNE getNe() {
        return ne;
    }

    public void setNe(LocationNameDOViewportNE ne) {
        this.ne = ne;
    }

    public LocationNameDOViewportSW getSw() {
        return sw;
    }

    public void setSw(LocationNameDOViewportSW sw) {
        this.sw = sw;
    }

    @Override
    public String toString() {
        return "LocationNameDOViewport{" +
                "ne=" + ne +
                ", sw=" + sw +
                '}';
    }
}
