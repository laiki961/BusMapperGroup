package com.fsse.busmapper.domain.dto.external.response.routeStop;

import java.util.List;

public class CtbRouteStopResponseExtDto {
    private String type;
    private List<CtbRouteStopDataResponseExtDto> data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<CtbRouteStopDataResponseExtDto> getData() {
        return data;
    }

    public void setData(List<CtbRouteStopDataResponseExtDto> data) {
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
