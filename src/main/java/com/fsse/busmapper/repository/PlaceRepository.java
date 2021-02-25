package com.fsse.busmapper.repository;

import com.fsse.busmapper.domain.entity.PlaceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends CrudRepository<PlaceEntity, Integer> {
    List<PlaceEntity> findAll();

    PlaceEntity findByPlaceSearchId(Integer placeSearchId);
}
