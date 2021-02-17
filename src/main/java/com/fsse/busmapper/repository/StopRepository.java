package com.fsse.busmapper.repository;

import com.fsse.busmapper.domain.entity.StopEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StopRepository extends CrudRepository <StopEntity, String>{
    List<StopEntity> findByStopId(String stopId);
}
