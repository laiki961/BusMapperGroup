package com.fsse.busmapper.domain.dto.internal.response.place;

import com.fsse.busmapper.domain.Place;

import java.util.List;

public class SearchBusRouteDto {
    private List<SearchBusRouteDto> response;

//    public Place SearchBusRouteDO(){
//
//    }

    public List<SearchBusRouteDto> getResponse() {
        return response;
    }

    public void setResponse(List<SearchBusRouteDto> response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "SearchBusRouteDto{" +
                "response=" + response +
                '}';
    }
}
