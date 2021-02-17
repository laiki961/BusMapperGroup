package com.fsse.busmapper.repository;

import com.fsse.busmapper.domain.entity.RouteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RouteRepository extends CrudRepository<RouteEntity, String> {
    List<RouteEntity> findByRouteId(String routeId);

}
