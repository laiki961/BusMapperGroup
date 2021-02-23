package com.fsse.busmapper.service.external;

import com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceNameResponseExtDto.GoogleSearchPlaceNameResponseExtDto;

public interface GoogleTurnCoortoNameExtService {
    GoogleSearchPlaceNameResponseExtDto loadLocationName(Double lat, Double lng);
}
