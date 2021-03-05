package com.fsse.busmapper.repository;


import com.fsse.busmapper.domain.entity.RouteEntity;
import com.fsse.busmapper.domain.entity.StopEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StopRepository extends CrudRepository<StopEntity, String> {
    List<StopEntity> findAll();
    List<StopEntity> findByLatitudeBetweenAndLongitudeBetween (Double latLowerBound, Double latUpperBound, Double lngLowerBound, Double lngUpperBound);
    StopEntity findByStopId(String stopId);
}
