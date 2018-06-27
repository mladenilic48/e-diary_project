package com.ITtraining.gradebook.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ITtraining.gradebook.entities.PupilEntity;

public interface PupilRepository extends CrudRepository<PupilEntity, Integer> {

}
