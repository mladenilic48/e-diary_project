package com.ITtraining.gradebook.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ITtraining.gradebook.entities.SubjectGradeEntity;

public interface SubjectGradeRepository extends CrudRepository<SubjectGradeEntity, Integer> {

}
