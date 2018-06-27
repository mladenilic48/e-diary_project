package com.ITtraining.gradebook.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ITtraining.gradebook.entities.PupilGradeEntity;

public interface PupilGradeRepository extends CrudRepository<PupilGradeEntity, Integer> {

}
