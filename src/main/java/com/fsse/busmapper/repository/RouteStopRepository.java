package com.fsse.busmapper.repository;

import com.fsse.busmapper.domain.entity.RouteStopEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RouteStopRepository extends CrudRepository<RouteStopEntity, String> {
    List<RouteStopEntity> findByRouteId(String routeId);
}
