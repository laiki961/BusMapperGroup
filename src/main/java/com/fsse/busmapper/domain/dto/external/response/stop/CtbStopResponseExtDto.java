package com.fsse.busmapper.domain.dto.external.response.stop;

import com.fsse.busmapper.domain.Stop;

import java.util.ArrayList;
import java.util.List;

public class CtbStopResponseExtDto {
    private String type;
    private List<CtbStopDataResponseExtDto> data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<CtbStopDataResponseExtDto> getData() {
        return data;
    }

    public void setData(List<CtbStopDataResponseExtDto> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CtbStopResponseExtDto{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }

    public List<Stop> toStopDo(){
        List<Stop> stopDo = new ArrayList<>();
        for(int i=0; i<data.size(); i++){
            CtbStopDataResponseExtDto item = data.get(i);
            Stop stop = new Stop();
            stop.setStopId(item.getStop());
            stop.setStopname(item.getName_en());
            stop.setLatitude(item.getLat());
            stop.setLongitude(item.getLongitude());
            stopDo.add(stop);
        }
        return stopDo;
    }


}
