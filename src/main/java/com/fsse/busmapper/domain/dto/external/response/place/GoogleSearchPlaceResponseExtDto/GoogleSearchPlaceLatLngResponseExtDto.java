package com.fsse.busmapper.domain.dto.external.response.place.GoogleSearchPlaceResponseExtDto;

import java.util.List;

public class GoogleSearchPlaceLatLngResponseExtDto {
    private List<GoogleSearchPlaceResponseExtDtoResult> results;


    public List<GoogleSearchPlaceResponseExtDtoResult> getResults() {
        return results;
    }

    public void setResults(List<GoogleSearchPlaceResponseExtDtoResult> results) {
        this.results = results;
    }

//    public LocationNameDO toLocationNameDO (){
//        LocationNameDO locationNameDO = new LocationNameDO();
//        for (int i=0;i<results.size();i++) {
//            locationNameDO.setFormatAdd();
//            //todo
//        }
    }



