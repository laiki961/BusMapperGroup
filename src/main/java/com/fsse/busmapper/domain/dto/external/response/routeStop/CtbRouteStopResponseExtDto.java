package com.fsse.busmapper.domain.dto.external.response.routeStop;

public class CtbRouteStopResponseExtDto {
    private String type;
    private CtbRouteStopDataResponseExtDto data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CtbRouteStopDataResponseExtDto getData() {
        return data;
    }

    public void setData(CtbRouteStopDataResponseExtDto data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CtbRouteStopResponseExtDto{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
