package com.fsse.busmapper.repository;

import com.fsse.busmapper.domain.entity.SearchPlaceHistoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface GooglePlaceLocationNameRepository extends CrudRepository<SearchPlaceHistoryEntity,String> {
}
