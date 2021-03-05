package com.fsse.busmapper.domain;

import com.fsse.busmapper.domain.entity.EstTimeEntity;

public class EstTime {
    private String stop;
    private String eta;

    public EstTimeEntity toEstTimeEntity() {
        EstTimeEntity entity = new EstTimeEntity();
        entity.setStopId(getStop());
        entity.setEta(getEta());
        return entity;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }
}
