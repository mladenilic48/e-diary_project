package com.ITtraining.gradebook.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ITtraining.gradebook.entities.SchoolClassEntity;

public interface SchoolClassRepository extends CrudRepository<SchoolClassEntity, Integer> {

}
