package com.fsse.busmapper.domain.dto.external;

import com.fsse.busmapper.domain.GoogleSearchPlaceNameResponseExtDO;
import com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceCoorResponseExtDto.GoogleSearchPlaceCoorResultResponseExtDto;

public class SearchPlaceCoorResponseExtDto {
    private GoogleSearchPlaceCoorResultResponseExtDto result;
    private String status;

    public GoogleSearchPlaceNameResponseExtDO toSearchPlaceCoorDo() {
        GoogleSearchPlaceNameResponseExtDO searchPlaceCoorDo = new GoogleSearchPlaceNameResponseExtDO();

        searchPlaceCoorDo.setFormatAdd(result.getFormatAdd());
        searchPlaceCoorDo.setLocationLat(result.getGeometry().getLocation().getLat());
        searchPlaceCoorDo.setLocationLng(result.getGeometry().getLocation().getLng());
        searchPlaceCoorDo.setViewportNeLat(result.getGeometry().getViewport().getNe().getLat());
        searchPlaceCoorDo.setViewportNeLng(result.getGeometry().getViewport().getNe().getLng());
        searchPlaceCoorDo.setViewportSwLat(result.getGeometry().getViewport().getSw().getLat());
        searchPlaceCoorDo.setViewportSwLng(result.getGeometry().getViewport().getSw().getLng());
        return searchPlaceCoorDo;
    }

    public GoogleSearchPlaceCoorResultResponseExtDto getResult() {
        return result;
    }

    public void setResult(GoogleSearchPlaceCoorResultResponseExtDto result) {
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
