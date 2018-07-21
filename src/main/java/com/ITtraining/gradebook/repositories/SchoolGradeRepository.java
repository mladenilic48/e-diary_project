package com.ITtraining.gradebook.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ITtraining.gradebook.entities.SchoolGradeEntity;

public interface SchoolGradeRepository extends CrudRepository<SchoolGradeEntity, Integer> {

}
