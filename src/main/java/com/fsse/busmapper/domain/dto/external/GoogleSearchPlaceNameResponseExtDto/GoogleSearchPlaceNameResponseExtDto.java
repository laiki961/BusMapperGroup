package com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceNameResponseExtDto;

import com.fsse.busmapper.domain.LocationNameDO;
import com.fsse.busmapper.domain.dto.GoogleSearchPlaceNameResponseDto.GoogleSearchPlaceNameResponseViewport;

import java.util.List;

public class GoogleSearchPlaceNameResponseExtDto {
    private List<GoogleSearchPlaceNameResponseExtDtoResult> results;


    public List<GoogleSearchPlaceNameResponseExtDtoResult> getResults() {
        return results;
    }

    public void setResults(List<GoogleSearchPlaceNameResponseExtDtoResult> results) {
        this.results = results;
    }

    //pass name,location,viewport,placeID to DO
//    public LocationNameDO toLocationNameDO(){
//        GoogleSearchPlaceNameResponseExtDtoResult response = new GoogleSearchPlaceNameResponseExtDtoResult();
//        response.setPlaceId(response.getPlaceId());
//        response.setGeometry(response.getGeometry());
//        return response;
//    }
}

