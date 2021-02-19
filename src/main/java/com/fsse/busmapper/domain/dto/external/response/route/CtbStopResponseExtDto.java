package com.fsse.busmapper.domain.dto.external.response.route;

import com.fsse.busmapper.domain.Stop;

import java.util.List;

public class CtbStopResponseExtDto {
    private CtbStopDataResponseExtDto data;

    public Stop toStop() {
        Stop stopDO = new Stop();
        stopDO.setStopId(data.getStopId());
        stopDO.setStopName(data.getStopName());
        stopDO.setLat(data.getLat());
        stopDO.setLng(data.getLng());

        return stopDO;
    }

    public CtbStopDataResponseExtDto getData() {
        return data;
    }

    public void setData(CtbStopDataResponseExtDto data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CtbStopResponseExtDto{" +
                "data=" + data +
                '}';
    }
}
