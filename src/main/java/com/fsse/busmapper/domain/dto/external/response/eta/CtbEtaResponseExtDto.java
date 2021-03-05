//package com.fsse.busmapper.domain.dto.external.response.eta;
//
//import com.fsse.busmapper.domain.Eta;
//import com.fsse.busmapper.domain.Route;
//import com.fsse.busmapper.domain.dto.external.response.route.CtbRouteDataResponseExtDto;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CtbEtaResponseExtDto {
//    private List<CtbEtaDataResponseExtDto> data;
//
//    public Eta toEtaDO(){
////        Eta etaDO = new Eta();
////        etaDO.setRouteId();
////        etaDO.setDir();
////        etaDO.setDir();
////        etaDO.setStops();
////        etaDO.setStopId();
////        etaDO.setEstTimestamp();
////        etaDO.setDestinationStop();
////    }
//
//        List<CtbEtaDataResponseExtDto> ctbEtaDataResponseExtDtos = new ArrayList<>();
//        for (int i=0; i<data.size(); i++) {
//            CtbEtaDataResponseExtDto ctbEtaDataResponseExtDto = new CtbEtaDataResponseExtDto();
//            ctbEtaDataResponseExtDto.setRoute(data.get(i).getRoute());
//            ctbEtaDataResponseExtDto.setDir(data.get(i).getDir());
//            ctbEtaDataResponseExtDto.setSeq(data.get(i).getSeq());
//            ctbEtaDataResponseExtDto.setStop(data.get(i).getStop());
//            ctbEtaDataResponseExtDto.setDest_en(data.get(i).getDest_en());
//            ctbEtaDataResponseExtDto.setEta(data.get(i).getEta());
//            ctbEtaDataResponseExtDto.setEta_seq(data.get(i).getEta_seq());
//            ctbEtaDataResponseExtDtos.add(ctbEtaDataResponseExtDto);
//        }
//        return ctbEtaDataResponseExtDtos;
//    }
//
//
//
//    public List<CtbEtaDataResponseExtDto> getData() {
//        return data;
//    }
//
//    public void setData(List<CtbEtaDataResponseExtDto> data) {
//        this.data = data;
//    }
//
//    @Override
//    public String toString() {
//        return "CtbEtaResponseExtDto{" +
//                "data=" + data +
//                '}';
//    }
//}
