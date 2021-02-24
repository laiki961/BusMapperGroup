package com.fsse.busmapper.domain.dto.external.response.place.GoogleSearchPlaceResponseExtDto;

import com.fsse.busmapper.domain.Place;
import com.fsse.busmapper.service.impl.GooglePlaceSearchServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoogleSearchPlaceIdResponseExtDto {

    Logger logger = LoggerFactory.getLogger(GoogleSearchPlaceIdResponseExtDto.class);

    private GoogleSearchPlaceResponseExtDtoResult result;
    private String status;

    public Place toPlaceExtDo() {
        Place placeDO = new Place();
        placeDO.setFormatAdd(result.getFormatAdd());
        placeDO.setLocationLat(result.getGeometry().getLocation().getLat());
        placeDO.setLocationLng(result.getGeometry().getLocation().getLng());
        placeDO.setViewportNeLat(result.getGeometry().getViewport().getNe().getLat());
        placeDO.setViewportNeLng(result.getGeometry().getViewport().getNe().getLng());
        placeDO.setViewportSwLat(result.getGeometry().getViewport().getSw().getLat());
        placeDO.setViewportSwLng(result.getGeometry().getViewport().getSw().getLng());
        logger.debug("received 2: {}", placeDO );
        return placeDO;
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
