package com.fsse.busmapper.repository;

import com.fsse.busmapper.domain.RouteStop;
import com.fsse.busmapper.domain.entity.RouteStopEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteStopRepository extends CrudRepository<RouteStopEntity, Integer> {
}
