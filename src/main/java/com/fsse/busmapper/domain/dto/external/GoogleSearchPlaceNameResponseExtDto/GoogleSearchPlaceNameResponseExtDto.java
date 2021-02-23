package com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceNameResponseExtDto;

import com.fsse.busmapper.domain.LocationNameDO;
import com.fsse.busmapper.domain.dto.GoogleSearchPlaceNameResponseDto.GoogleSearchPlaceNameResponseViewport;
import com.fsse.busmapper.domain.entity.SearchPlaceHistoryEntity;

import javax.xml.stream.Location;
import java.util.List;

public class GoogleSearchPlaceNameResponseExtDto {
    private List<GoogleSearchPlaceNameResponseExtDtoResult> results;


    public List<GoogleSearchPlaceNameResponseExtDtoResult> getResults() {
        return results;
    }

    public void setResults(List<GoogleSearchPlaceNameResponseExtDtoResult> results) {
        this.results = results;
    }

//    public LocationNameDO toLocationNameDO (){
//        LocationNameDO locationNameDO = new LocationNameDO();
//        for (int i=0;i<results.size();i++) {
//            locationNameDO.setFormatAdd();
//            //todo
//        }
    }



