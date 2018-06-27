package com.ITtraining.gradebook.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ITtraining.gradebook.entities.AdministratorEntity;

public interface AdministratorRepository extends CrudRepository<AdministratorEntity, Integer> {

}
