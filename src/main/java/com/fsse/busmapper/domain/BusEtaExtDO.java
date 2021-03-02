package com.fsse.busmapper.domain;

public class BusEtaExtDO {
    private String dir;
    private String seq;
    private String eta;

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
