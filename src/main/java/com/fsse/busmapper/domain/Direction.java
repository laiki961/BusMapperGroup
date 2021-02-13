package com.fsse.busmapper.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Direction {
    @Id
    private String direction;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "direction='" + direction + '\'' +
                '}';
    }
}
