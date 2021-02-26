package com.fsse.busmapper.domain.dto.external.response.place.GoogleSearchPlaceResponseExtDto;

import com.fsse.busmapper.domain.Place;

import java.util.List;

public class GoogleSearchPlaceLatLngResponseExtDto {
    private List<GoogleSearchPlaceResponseExtDtoResult> results;

    public Place toPlaceExtDo() {
        Place placeDO = new Place();
        placeDO.setFormatAdd(results.get(0).getFormatAdd());
        placeDO.setLocationLat(results.get(0).getGeometry().getLocation().getLat());
        placeDO.setLocationLng(results.get(0).getGeometry().getLocation().getLng());
        placeDO.setViewportNeLat(results.get(0).getGeometry().getViewport().getNe().getLat());
        placeDO.setViewportNeLng(results.get(0).getGeometry().getViewport().getNe().getLng());
        placeDO.setViewportSwLat(results.get(0
        ).getGeometry().getViewport().getSw().getLat());
        placeDO.setViewportSwLng(results.get(0).getGeometry().getViewport().getSw().getLng());
        return placeDO;
    }

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



