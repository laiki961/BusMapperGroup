package com.fsse.busmapper.repository;

import com.fsse.busmapper.domain.entity.RouteEntity;
import com.fsse.busmapper.domain.entity.StopEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopRepository extends CrudRepository<StopEntity, String> {
}
