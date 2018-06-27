package com.ITtraining.gradebook.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ITtraining.gradebook.entities.ParentEntity;

public interface ParentRepository extends CrudRepository<ParentEntity, Integer> {

}
