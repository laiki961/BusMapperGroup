package com.fsse.busmapper.domain.dto.internal.response.bus;

public class CtbEstTimeDataResponseDto {
    private String stop;
    private String estTimestamp;

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getEstTimestamp() {
        return estTimestamp;
    }

    public void setEstTimestamp(String estTimestamp) {
        this.estTimestamp = estTimestamp;
    }
}
