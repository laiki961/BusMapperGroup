package com.fsse.busmapper.repository;

import com.fsse.busmapper.domain.Route;
import com.fsse.busmapper.domain.entity.RouteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends CrudRepository<RouteEntity, String> {
    List<Route> findById(List<String> routeId);
}
