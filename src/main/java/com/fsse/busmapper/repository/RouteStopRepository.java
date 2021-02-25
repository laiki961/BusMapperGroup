package com.fsse.busmapper.repository;

import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.entity.RouteEntity;
import com.fsse.busmapper.domain.entity.RouteStopEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteStopRepository extends CrudRepository<RouteStopEntity, Integer> {
    List<RouteStopEntity> findAll();
    List<RouteStopEntity> findByStopEntity_StopId(String stopId);

}
