package com.fsse.busmapper.domain.dto.external.response.stop;

public class CtbStopResponseExtDto {
    private String type;
    private CtbStopDataResponseExtDto data;

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
