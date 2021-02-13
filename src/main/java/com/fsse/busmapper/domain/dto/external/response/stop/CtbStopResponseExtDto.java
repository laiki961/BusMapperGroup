package com.fsse.busmapper.domain.dto.external.response.stop;

import com.fsse.busmapper.domain.Stop;
import org.springframework.beans.factory.annotation.Autowired;

public class CtbStopResponseExtDto {
    private String type;
    private CtbStopDataResponseExtDto data;
//    @Autowired
//    private CtbStopDataResponseExtDto ctbStopDataResponseExtDto;
//
//    public Stop toStop(){
//        Stop stop = new Stop();
//        stop.setLatitude(ctbStopDataResponseExtDto.getLatitude());
//        stop.setLongitude(ctbStopDataResponseExtDto.getLongitude());
//        return stop;
//    }

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
}
