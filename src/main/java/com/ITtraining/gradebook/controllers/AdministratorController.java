package com.ITtraining.gradebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ITtraining.gradebook.controllers.util.RESTError;
import com.ITtraining.gradebook.entities.AdministratorEntity;
import com.ITtraining.gradebook.entities.dto.AdministratorDTO;
import com.ITtraining.gradebook.repositories.AdministratorRepository;

@RestController
@RequestMapping(value="/api/v1/gradebook/admins")
public class AdministratorController {

	@Autowired
	private AdministratorRepository adminRepo;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAdministrators() {
		return new ResponseEntity<Iterable<AdministratorEntity>>(adminRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> getAdminById(@PathVariable Integer id) {

		if (adminRepo.findById(id).isPresent()) {
			return new ResponseEntity<AdministratorEntity>(adminRepo.findById(id).get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<RESTError>(new RESTError(1, "Admin with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addAdmin(@RequestBody AdministratorDTO newAdmin) {

		if (newAdmin == null) {
			return new ResponseEntity<RESTError>(new RESTError(2, "Admin object is invalid."), HttpStatus.BAD_REQUEST);
		}

		if (newAdmin.getName() == null || newAdmin.getSurname() == null || newAdmin.getUsername() == null
				|| newAdmin.getPassword() == null) {
			return new ResponseEntity<RESTError>(new RESTError(2, "Admin object is invalid."), HttpStatus.BAD_REQUEST);
		}

		AdministratorEntity administratorEntity = new AdministratorEntity();
		administratorEntity.setName(newAdmin.getName());
		administratorEntity.setSurname(newAdmin.getSurname());
		administratorEntity.setUsername(newAdmin.getUsername());
		administratorEntity.setPassword(newAdmin.getPassword());

		return new ResponseEntity<AdministratorEntity>(adminRepo.save(administratorEntity), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<?> updateAdmin(@PathVariable Integer id, @RequestBody AdministratorDTO updateAdmin) {

		if (!adminRepo.existsById(id)) {
			return new ResponseEntity<RESTError>(new RESTError(1, "Admin with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}

		AdministratorEntity administratorEntity = adminRepo.findById(id).get();

		if (updateAdmin.getName() != null && !updateAdmin.getName().equals("") && !updateAdmin.getName().equals(" ")) {
			administratorEntity.setName(updateAdmin.getName());
		}

		if (updateAdmin.getSurname() != null && !updateAdmin.getSurname().equals("")
				&& !updateAdmin.getSurname().equals(" ")) {
			administratorEntity.setSurname(updateAdmin.getSurname());
		}

		if (updateAdmin.getUsername() != null && !updateAdmin.getUsername().equals("")
				&& !updateAdmin.getUsername().equals(" ")) {
			administratorEntity.setUsername(updateAdmin.getUsername());
		}

		return new ResponseEntity<AdministratorEntity>(adminRepo.save(administratorEntity), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteAdmin(@PathVariable Integer id) {

		if (adminRepo.findById(id).isPresent()) {
			AdministratorEntity administratorEntity = adminRepo.findById(id).get();
			adminRepo.deleteById(id);
			return new ResponseEntity<AdministratorEntity>(administratorEntity, HttpStatus.OK);
		} else {
			return new ResponseEntity<RESTError>(new RESTError(1, "Admin with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}
	}

}
