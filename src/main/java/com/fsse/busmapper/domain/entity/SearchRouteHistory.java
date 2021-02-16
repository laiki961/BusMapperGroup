package com.fsse.busmapper.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "SearchRouteHistory")
public class SearchRouteHistory {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;


}
