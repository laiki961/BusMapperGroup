package com.fsse.busmapper.api;

import com.fsse.busmapper.domain.EstTime;
import com.fsse.busmapper.domain.dto.internal.response.bus.CtbEstTimeResponseDto;
import com.fsse.busmapper.domain.dto.internal.response.bus.FetchDataFromCTBResponseDto;
import com.fsse.busmapper.domain.entity.RouteStopEntity;
import com.fsse.busmapper.domain.entity.StopEntity;
import com.fsse.busmapper.service.NwfbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BusSearchingApi {
    @Autowired
    private NwfbService nwfbService;

    //API 1
    @GetMapping("/load/all-buses-details")
    public FetchDataFromCTBResponseDto loadAllBusData(){
        return nwfbService.loadAllBusData();
    }

    //API 5
    @GetMapping("/load/estTime/{origStopId}/{routeId}/{direction}/{destStop}")
    public CtbEstTimeResponseDto loadEstTime(@PathVariable("origStopId") String origStopId, @PathVariable("routeId") String routeId, @PathVariable("direction") String direction, @PathVariable("destStop") String destStop) {

        List<RouteStopEntity> routeStopEntities = nwfbService.routeStopEntities(routeId, direction);
        List<StopEntity> stopEntityList = nwfbService.stopEntityList(routeId, direction);
        EstTime estTimeDo = nwfbService.loadEstTime(origStopId, routeId);
        CtbEstTimeResponseDto dto = new CtbEstTimeResponseDto(estTimeDo, routeId, routeStopEntities, stopEntityList, direction, destStop);
        return dto;

    }
}
