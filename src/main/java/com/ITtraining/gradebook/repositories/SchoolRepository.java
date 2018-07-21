package com.ITtraining.gradebook.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ITtraining.gradebook.entities.SchoolEntity;

public interface SchoolRepository extends CrudRepository<SchoolEntity, Integer> {

}
