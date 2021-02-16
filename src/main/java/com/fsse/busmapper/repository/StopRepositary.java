package com.fsse.busmapper.repository;

import com.fsse.busmapper.domain.entity.Route;
import com.fsse.busmapper.domain.entity.Stop;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StopRepositary extends CrudRepository <Stop, String>{
    List<Stop> findByStopId(String stopId);
}
