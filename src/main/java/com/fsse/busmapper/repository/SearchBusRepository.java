package com.fsse.busmapper.repository;

import com.fsse.busmapper.domain.Stop;
import com.fsse.busmapper.domain.entity.StopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchBusRepository extends JpaRepository<StopEntity, String> {
    List<StopEntity> findByLatitudeBetweenAndLongitudeBetween (Double latLowerBound, Double latUpperBound, Double lngLowerBound, Double lngUpperBound);

}
