package com.fsse.busmapper.repository;


import com.fsse.busmapper.domain.entity.EstTimeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstTimeRepository extends CrudRepository<EstTimeEntity, Integer> {
}
