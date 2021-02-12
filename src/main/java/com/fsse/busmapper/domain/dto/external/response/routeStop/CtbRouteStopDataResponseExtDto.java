package com.fsse.busmapper.domain.dto.external.response.routeStop;

public class CtbRouteStopDataResponseExtDto {
    private String co;
    private String route;
    private String dir;
    private int seq;
    public String stop;

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

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

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    @Override
    public String toString() {
        return "CtbRouteStopDataResponseExtDto{" +
                "co='" + co + '\'' +
                ", route='" + route + '\'' +
                ", dir='" + dir + '\'' +
                ", seq=" + seq +
                ", stop='" + stop + '\'' +
                '}';
    }
}
