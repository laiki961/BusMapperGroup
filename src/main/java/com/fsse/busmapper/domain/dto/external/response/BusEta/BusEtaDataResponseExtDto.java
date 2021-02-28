package com.fsse.busmapper.domain.dto.external.response;

import com.fsse.busmapper.domain.BusEtaExtDO;

public class BusEtaDataResponseExtDto {
    private String dir;
    private String seq;
    private String eta;

    public BusEtaExtDO toBusEtaExtDO(){
        //todo
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

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "BusEtaResponseExtDto{" +
                "dir='" + dir + '\'' +
                ", seq='" + seq + '\'' +
                ", eta='" + eta + '\'' +
                '}';
    }
}
