package com.fsse.busmapper.repository;

import com.fsse.busmapper.domain.entity.Route;
import com.fsse.busmapper.domain.entity.RouteStop;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RouteStopRepositary extends CrudRepository<RouteStop, String> {
    List<RouteStop> findByRouteId(String routeId);
}
