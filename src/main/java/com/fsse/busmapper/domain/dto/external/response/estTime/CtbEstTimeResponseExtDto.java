package com.fsse.busmapper.domain.dto.external.response.estTime;

import com.fsse.busmapper.domain.EstTime;

import java.util.List;

public class CtbEstTimeResponseExtDto {
    List<CtbEstTimeDataResponseExtDto> data;

    public EstTime toEstTimeDo() {
        EstTime estTime = new EstTime();

        estTime.setStop(data.get(0).getStop());
        estTime.setEta(data.get(0).getEta());
        return  estTime;
    }

    public List<CtbEstTimeDataResponseExtDto> getData() {
    return data;
    }

    public void setData(List<CtbEstTimeDataResponseExtDto> data) {
        this.data = data;
    }
}
