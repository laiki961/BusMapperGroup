package com.fsse.busmapper.domain.dto.external.response.route;

public class CtbRouteResponseExtDto {
    private String type;
    private CtbRouteDataResponseExtDto data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CtbRouteDataResponseExtDto getData() {
        return data;
    }

    public void setData(CtbRouteDataResponseExtDto data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CtbRouteResponseExtDto{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
