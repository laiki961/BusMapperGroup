package com.fsse.busmapper.repository;

import com.fsse.busmapper.domain.entity.Route;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RouteRepositary extends CrudRepository<Route, String> {
    List<Route> findByRouteId(String routeId);

}
