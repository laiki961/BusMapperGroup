package com.fsse.busmapper.api;


import com.fsse.busmapper.domain.dto.external.GoogleSearchPlaceNameResponseExtDto.GoogleSearchPlaceNameResponseExtDto;
import com.fsse.busmapper.service.GoogleTurnCoortoNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/namesearch")
public class NameSearchApi {
    @Autowired
    private GoogleTurnCoortoNameService googleTurnCoortoNameService;

    @GetMapping("/{lat}/{lng}")
    public GoogleSearchPlaceNameResponseExtDto loadLocationName(@PathVariable("lat") Double lat, @PathVariable("lng") Double lng){
        return googleTurnCoortoNameService.loadLocationName(lat, lng);

    }

}
