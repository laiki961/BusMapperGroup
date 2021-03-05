package com.fsse.busmapper.domain.dto.external.response.BusEta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fsse.busmapper.domain.BusEtaExtDO;

import java.util.List;
@JsonIgnoreProperties
public class BusEtaResponseExtDto {
    private List<BusEtaDataResponseExtDto> data;


    public BusEtaExtDO toBusEtaExtDO(){
        BusEtaExtDO busEtaExtDO = new BusEtaExtDO();
        BusEtaDataResponseExtDto busEtaDataResponseExtDto = new BusEtaDataResponseExtDto();
        busEtaExtDO.setDir(data.get(0).getDir());
        busEtaExtDO.setSeq(data.get(0).getSeq());
        busEtaExtDO.setEta(data.get(0).getEta());
        return busEtaExtDO;
    }

//    public BusEtaIntDO toBusEtaDto(){
//        //todo
//        // put stuff from do to dto
//        BusEtaIntDO busEtaIntDO = new BusEtaIntDO();
//        RouteStopEntity routeStopEntity = new RouteStopEntity();
//        StopEntity stopEntity = new StopEntity();
//
//        busEtaIntDO.setRoute(route);
//        busEtaIntDO.setDir(dir);
//        busEtaIntDO.setDestStop(destStop);
//
//        busEtaIntDO.setRouteStopEntity(routeStopEntity.getStopEntity().getStopId());
//        busEtaIntDO.setRouteStopEntity(routeStopEntity.getStopEntity().getLatitude());
//        busEtaIntDO.setRouteStopEntity(routeStopEntity.getStopEntity().getLongitude());
//        return busEtaIntDO;
//    }


    public List<BusEtaDataResponseExtDto> getData() {
        return data;
    }

    public void setData(List<BusEtaDataResponseExtDto> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BusEtaResponseExtDto{" +
                "data=" + data +
                '}';
    }
}
