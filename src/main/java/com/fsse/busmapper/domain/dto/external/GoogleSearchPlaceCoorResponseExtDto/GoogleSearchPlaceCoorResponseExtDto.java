package com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceCoorResponseExtDto;

import com.fsse.busmapper.domain.GoogleSearchPlaceNameResponseExtDO;

import java.util.List;

public class GoogleSearchPlaceCoorResponseExtDto {
    private List<GoogleSearchPlaceCoorResultResponseExtDto> results;


    public List<GoogleSearchPlaceCoorResultResponseExtDto> getResults() {
        return results;
    }

    public void setResults(List<GoogleSearchPlaceCoorResultResponseExtDto> results) {
        this.results = results;
    }

    public GoogleSearchPlaceNameResponseExtDO toLocationNameDO(){
        for(int i=0; i<results.size(); i++){
        GoogleSearchPlaceNameResponseExtDO googleSearchPlaceNameResponseExtDO = new GoogleSearchPlaceNameResponseExtDO();
        googleSearchPlaceNameResponseExtDO.setFormatAdd(results.get(i).getFormatAdd());
        googleSearchPlaceNameResponseExtDO.setPlaceId(results.get(i).getPlaceId());
        googleSearchPlaceNameResponseExtDO.setLocationLat(results.get(i).getGeometry().getLocation().getLat());
        googleSearchPlaceNameResponseExtDO.setLocationLng(results.get(i).getGeometry().getLocation().getLng());
        googleSearchPlaceNameResponseExtDO.setViewportNeLat(results.get(i).getGeometry().getViewport().getNe().getLat());
        googleSearchPlaceNameResponseExtDO.setViewportSwLat(results.get(i).getGeometry().getViewport().getSw().getLat());
        googleSearchPlaceNameResponseExtDO.setViewportNeLng(results.get(i).getGeometry().getViewport().getNe().getLng());
        googleSearchPlaceNameResponseExtDO.setViewportSwLng(results.get(i).getGeometry().getViewport().getSw().getLng());
        }
        return googleSearchPlaceNameResponseExtDO;
    }
}



