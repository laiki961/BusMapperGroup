package com.fsse.busmapper.domain.entity;

import javax.persistence.*;

@Entity
public class EstTimeEntity {
    @Id
    @Column(name = "est_time_id", nullable = true, unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer estTimeId;

    @Column
    private String stopId;
    @Column
    private String eta;

    public Integer getEstTimeId() {
        return estTimeId;
    }

    public void setEstTimeId(Integer estTimeId) {
        this.estTimeId = estTimeId;
    }

    public String getStopId() {
        return stopId;
    }

    public void setStopId(String stopId) {
        this.stopId = stopId;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "EstTimeEntity{" +
                "estTimeId=" + estTimeId +
                ", stopId='" + stopId + '\'' +
                ", eta='" + eta + '\'' +
                '}';
    }
}
