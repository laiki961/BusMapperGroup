package com.fsse.busmapper.domain.dto.external.response.stop;

import com.fsse.busmapper.domain.Stop;
import org.springframework.beans.factory.annotation.Autowired;

public class CtbStopResponseExtDto {
    private String type;
    private CtbStopDataResponseExtDto data;
    @Autowired
    private CtbStopDataResponseExtDto ctbStopDataResponseExtDto;

    public Stop toStop(){
        Stop stop = new Stop();
        stop.setLatitude(ctbStopDataResponseExtDto.getLat());
        stop.setLongitude(ctbStopDataResponseExtDto.getLongitude());
        return stop;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }

    public Stop toStop(){
        Stop stop = new Stop();
        stop.setStopId(stop.getStopId());
        stop.setStopname(stop.getStopname());
        stop.setLatitude(stop.getLatitude());
        stop.setLongitude(stop.getLongitude());
        return stop;
    }
}
