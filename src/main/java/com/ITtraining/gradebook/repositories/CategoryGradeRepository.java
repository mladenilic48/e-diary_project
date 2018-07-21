package com.ITtraining.gradebook.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ITtraining.gradebook.entities.CategoryGradesEntity;

public interface CategoryGradeRepository extends CrudRepository<CategoryGradesEntity, Integer> {

}
