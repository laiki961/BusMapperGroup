package com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceNameResponseExtDto;

import com.fsse.busmapper.domain.GoogleSearchPlaceNameResponseExtDO;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchPlaceNameResponseExtDto {
    private List<GoogleSearchPlaceNameResponseExtDtoResult> results;


    public List<GoogleSearchPlaceNameResponseExtDtoResult> getResults() {
        return results;
    }

    public void setResults(List<GoogleSearchPlaceNameResponseExtDtoResult> results) {
        this.results = results;
    }

    public GoogleSearchPlaceNameResponseExtDO toGoogleSearchPlaceNameResponseExtDO (){
        GoogleSearchPlaceNameResponseExtDO GoogleSearchPlaceNameResponseExtDO = new GoogleSearchPlaceNameResponseExtDO();
        List<GoogleSearchPlaceNameResponseExtDO> googleSearchPlaceNameResponseExtDOS = new ArrayList<>();
        for (int i=0;i<results.size();i++) {
            googleSearchPlaceNameResponseExtDOS.add();
        }
    }



