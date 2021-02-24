package com.fsse.busmapper.domain.dto.external.response.place.GoogleSearchPlaceResponseExtDto;

import com.fsse.busmapper.domain.Place;

public class GoogleSearchPlaceIdResponseExtDto {
    private GoogleSearchPlaceResponseExtDtoResult result;
    private String status;

    public Place toPlaceExtDo() {
        Place searchPlaceCoorDo = new Place();
        searchPlaceCoorDo.setFormatAdd(result.getFormatAdd());
        searchPlaceCoorDo.setLocationLat(result.getGeometry().getLocation().getLat());
        searchPlaceCoorDo.setLocationLng(result.getGeometry().getLocation().getLng());
        searchPlaceCoorDo.setViewportNeLat(result.getGeometry().getViewport().getNe().getLat());
        searchPlaceCoorDo.setViewportNeLng(result.getGeometry().getViewport().getNe().getLng());
        searchPlaceCoorDo.setViewportSwLat(result.getGeometry().getViewport().getSw().getLat());
        searchPlaceCoorDo.setViewportSwLng(result.getGeometry().getViewport().getSw().getLng());
        return searchPlaceCoorDo;
    }

    public GoogleSearchPlaceResponseExtDtoResult getResult() {
        return result;
    }

    public void setResult(GoogleSearchPlaceResponseExtDtoResult result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SearchPlaceCoorResponseExtDto{" +
                "result=" + result +
                ", status='" + status + '\'' +
                '}';
    }
}
