package com.fsse.busmapper.domain.dto.external.response.eta;

import com.fsse.busmapper.domain.Eta;

public class CtbEtaDataResponseExtDto {
    private String route;
    private String dir;
    private String seq;
    private String stop;
    private String dest_en;
    private String eta;
    private String eta_seq;

//    public Eta toEtaDO(){
//        Eta etaDO = new Eta();
//        etaDO.setRouteId();
//        etaDO.setDir();
//        etaDO.setDir();
//        etaDO.setStops();
//        etaDO.setStopId();
//        etaDO.setEstTimestamp();
//        etaDO.setDestinationStop();
//    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getDest_en() {
        return dest_en;
    }

    public void setDest_en(String dest_en) {
        this.dest_en = dest_en;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public String getEta_seq() {
        return eta_seq;
    }

    public void setEta_seq(String eta_seq) {
        this.eta_seq = eta_seq;
    }

    @Override
    public String toString() {
        return "CtbEtaDataResponseExtDto{" +
                "route='" + route + '\'' +
                ", dir='" + dir + '\'' +
                ", seq='" + seq + '\'' +
                ", stop='" + stop + '\'' +
                ", dest_en='" + dest_en + '\'' +
                ", eta='" + eta + '\'' +
                ", eta_seq='" + eta_seq + '\'' +
                '}';
    }
}
