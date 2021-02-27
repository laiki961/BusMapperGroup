package com.fsse.busmapper.domain.dto.external.response.routeStop;

import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class CtbRouteStopResponseExtDto {
    private List<CtbRouteStopDataResponseExtDto> data;




    public List<CtbRouteStopDataResponseExtDto> getData() {
        return data;
    }

    public void setData(List<CtbRouteStopDataResponseExtDto> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CtbRouteStopResponseExtDto{" +
                "data=" + data +
                '}';
    }
}
