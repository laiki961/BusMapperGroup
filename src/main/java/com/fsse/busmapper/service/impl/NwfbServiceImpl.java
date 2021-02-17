package com.fsse.busmapper.service.impl;

import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.Stop;
import com.fsse.busmapper.domain.entity.StopEntity;
import com.fsse.busmapper.repository.StopRepository;
import com.fsse.busmapper.service.NwfbService;
import com.fsse.busmapper.service.external.NwfbExtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NwfbServiceImpl implements NwfbService {
    @Autowired
    private NwfbExtService nwfbExtService;
    @Autowired
    private StopRepository stopRepository;


    @Override
    public Stop getBusStopInfo(String stopId) {
        Stop stop = nwfbExtService.stop(stopId);
        StopEntity stopEntity = stop.toStopEntity();
        stopEntity = stopRepository.save(stopEntity);

        return null;
    }

    @Override
    public RouteStop getRouteStopForSpecificBus(String route, String dir) {
        return null;
    }

    @Override
    public Route getBusOriNDest(String route) {
        return null;
    }
}
