package com.fsse.busmapper.service.external;

import com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceCoorResponseExtDto.GoogleSearchPlaceCoorResponseExtDto;

public interface GoogleTurnCoortoNameExtService {
    GoogleSearchPlaceCoorResponseExtDto loadLocationName(Double lat, Double lng);
}
