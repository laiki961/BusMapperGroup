package com.fsse.busmapper.domain.dto.internal.response.BusEta;

public class BusOriResponseDto {
    private String stop;
    private String estTimeStamp;

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getEstTimeStamp() {
        return estTimeStamp;
    }

    public void setEstTimeStamp(String estTimeStamp) {
        this.estTimeStamp = estTimeStamp;
    }
}
