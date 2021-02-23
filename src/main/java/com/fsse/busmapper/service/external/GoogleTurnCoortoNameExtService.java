package com.fsse.busmapper.service.external;

import com.fsse.busmapper.domain.LocationNameDO;
import com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceNameResponseExtDto.GoogleSearchPlaceNameResponseExtDto;
import com.fsse.busmapper.domain.dto.external.SearchPlaceCoorResponseExtDto;

public interface GoogleTurnCoortoNameExtService {
    GoogleSearchPlaceNameResponseExtDto loadLocationName(Double lat, Double lng);
    LocationNameDO locationNameDO(String placedId);
}
