package com.fsse.busmapper.repository;

import com.fsse.busmapper.domain.entity.PlaceEntity;
import com.fsse.busmapper.domain.entity.StopEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//place a query definition just above the method inside the repository rather than inside our domain model as named queries
@Repository
public interface PlaceRepository extends CrudRepository<PlaceEntity, Integer> {
    List<PlaceEntity> findAll();

    @Query ("SELECT stopId FROM stop WHERE latitude BETWEEN AND longitude BETWEEN")
    List<StopEntity> findAllById(List<StopEntity> ids);
}
