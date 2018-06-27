package com.ITtraining.gradebook.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ITtraining.gradebook.entities.GradeEntity;

public interface GradeRepository extends CrudRepository<GradeEntity, Integer> {

}
