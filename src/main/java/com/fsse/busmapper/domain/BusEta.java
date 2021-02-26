package com.fsse.busmapper.domain;

public class BusEta {
    private String eta;
    private String dir;
    private String seq;

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
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

    @Override
    public String toString() {
        return "BusEta{" +
                "eta='" + eta + '\'' +
                ", dir='" + dir + '\'' +
                ", seq='" + seq + '\'' +
                '}';
    }
}
