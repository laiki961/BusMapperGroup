package com.fsse.busmapper.repository;

import com.fsse.busmapper.domain.Route;
import org.springframework.data.repository.CrudRepository;

public interface RouteRepositary extends CrudRepository<Route, String> {
}
