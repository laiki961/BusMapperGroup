package com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceNameResponseExtDto;

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



