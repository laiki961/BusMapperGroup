package com.fsse.busmapper.domain.dto.internal.response.place;

import com.fsse.busmapper.domain.SearchBusRoute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchBusRouteDto {
    private List<SearchBusRouteResponseDto> response;

    Logger logger = LoggerFactory.getLogger(SearchBusRouteDto.class);

    public SearchBusRouteDto(){}

    public SearchBusRouteDto(List<SearchBusRoute> busRouteDetails){
        this.response = new ArrayList<>();

        for(int i=0; i<busRouteDetails.size(); i++){
            SearchBusRouteResponseDto dto = new SearchBusRouteResponseDto();
            dto.setCo(busRouteDetails.get(i).getCo());
            dto.setRoute(busRouteDetails.get(i).getRoute());
            dto.setDirection(busRouteDetails.get(i).getDirection());
            logger.debug(busRouteDetails.get(i).getDirection());
            dto.setOrigName(busRouteDetails.get(i).getOrigName());
            logger.debug(busRouteDetails.get(i).getOrigName());
            dto.setOrigStop(busRouteDetails.get(i).getOrigStop());
            logger.debug(busRouteDetails.get(i).getOrigStop());
            dto.setDestName(busRouteDetails.get(i).getDestName());
            logger.debug(busRouteDetails.get(i).getDestName());
            dto.setDestStop(busRouteDetails.get(i).getDestStop());
            response.add(dto);
        }
    }

    public List<SearchBusRouteResponseDto> getResponse() {
        return response;
    }

    public void setResponse(List<SearchBusRouteResponseDto> response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "SearchBusRouteDto{" +
                "response=" + response +
                '}';
    }
}
