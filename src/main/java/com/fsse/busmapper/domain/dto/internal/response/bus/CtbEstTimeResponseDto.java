package com.fsse.busmapper.domain.dto.internal.response.bus;


import com.fsse.busmapper.domain.EstTime;
import com.fsse.busmapper.domain.entity.RouteStopEntity;
import com.fsse.busmapper.domain.entity.StopEntity;
import com.fsse.busmapper.repository.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CtbEstTimeResponseDto {
    private String route;
    private String direction;
    private List<CtbStopInfoResponseDto> stops;
    private CtbEstTimeDataResponseDto origin;
    private String destinationStop;
    @Autowired
    private StopRepository stopRepository;

    public CtbEstTimeResponseDto() {}

    public CtbEstTimeResponseDto(EstTime estTime, String routeId, List<RouteStopEntity> routeStopEntities, List<StopEntity> stopEntityList, String direction, String destStop) {
        this.route = routeId;
        this.direction = direction;

        List<CtbStopInfoResponseDto> stops = new ArrayList<>();

        for (int i = 0; i < routeStopEntities.size() ; i++) {

            CtbStopInfoResponseDto dto = new CtbStopInfoResponseDto();
            dto.setStop(routeStopEntities.get(i).getStopEntity().getStopId());
            dto.setSeq(routeStopEntities.get(i).getSeq());

            dto.setName(stopEntityList.get(i).getStopname());
            dto.setLat(stopEntityList.get(i).getLatitude());
            dto.setLng(stopEntityList.get(i).getLongitude());

            stops.add(dto);
        }
        this.stops = stops;

        CtbEstTimeDataResponseDto origin = new CtbEstTimeDataResponseDto();

        origin.setStop(estTime.getStop());
        origin.setEstTimestamp(estTime.getEta());
        this.origin = origin;
        this.destinationStop= destStop;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public List<CtbStopInfoResponseDto> getStops() {
        return stops;
    }

    public void setStops(List<CtbStopInfoResponseDto> stops) {
        this.stops = stops;
    }

    public CtbEstTimeDataResponseDto getOrigin() {
        return origin;
    }

    public void setOrigin(CtbEstTimeDataResponseDto origin) {
        this.origin = origin;
    }

    public String getDestinationStop() {
        return destinationStop;
    }

    public void setDestinationStop(String destinationStop) {
        this.destinationStop = destinationStop;
    }

    @Override
    public String toString() {
        return "CtbEstTimeResponseDto{" +
                "route='" + route + '\'' +
                ", direction='" + direction + '\'' +
                ", stops=" + stops +
                ", origin=" + origin +
                ", destinationStop='" + destinationStop + '\'' +
                '}';
    }
}
