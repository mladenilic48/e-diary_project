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
import com.ITtraining.gradebook.entities.SchoolEntity;
import com.ITtraining.gradebook.repositories.SchoolRepository;

@RestController
@RequestMapping(value = "/api/v1/gradebook/schools")
public class SchoolController {

	@Autowired
	private SchoolRepository schoolRepo;

	@RequestMapping
	public ResponseEntity<?> getSchools() {
		return new ResponseEntity<Iterable<SchoolEntity>>(schoolRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> getSchoolById(@PathVariable Integer id) {
		if (schoolRepo.existsById(id)) {
			return new ResponseEntity<SchoolEntity>(schoolRepo.findById(id).get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<RESTError>(new RESTError(1, "School with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addNewSchool(@RequestBody SchoolEntity newSchool) {
		if (newSchool == null) {
			return new ResponseEntity<RESTError>(new RESTError(2, "School object is invalid."), HttpStatus.BAD_REQUEST);
		}

		if (newSchool.getAddress() == null || newSchool.getCity() == null || newSchool.getName() == null) {
			return new ResponseEntity<RESTError>(new RESTError(2, "School object is invalid."), HttpStatus.BAD_REQUEST);
		}

		if (newSchool.getCity().equals("") || newSchool.getCity().equals(" ") || newSchool.getName().equals("")
				|| newSchool.getName().equals(" ")) {
			return new ResponseEntity<RESTError>(new RESTError(2, "School object is invalid."), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<SchoolEntity>(schoolRepo.save(newSchool), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<?> updateSchool(@PathVariable Integer id, @RequestBody SchoolEntity updatedSchool) {
		if (updatedSchool == null) {
			return new ResponseEntity<RESTError>(new RESTError(2, "School object is invalid."), HttpStatus.BAD_REQUEST);
		}

		if (!schoolRepo.existsById(id)) {
			return new ResponseEntity<RESTError>(new RESTError(1, "School with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}

		SchoolEntity schoolEntity = schoolRepo.findById(id).get();

		if (!(updatedSchool.getAddress() == null || updatedSchool.getAddress().equals("")
				|| updatedSchool.getAddress().equals(" "))) {
			schoolEntity.setAddress(updatedSchool.getAddress());
		}

		if (!(updatedSchool.getCity() == null || updatedSchool.getCity().equals("")
				|| updatedSchool.getCity().equals(" "))) {
			schoolEntity.setCity(updatedSchool.getCity());
		}

		if (!(updatedSchool.getName() == null || updatedSchool.getName().equals("")
				|| updatedSchool.getName().equals(" "))) {
			schoolEntity.setName(updatedSchool.getName());
		}

		return new ResponseEntity<SchoolEntity>(schoolRepo.save(schoolEntity), HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteSchool(@PathVariable Integer id) {
		if (schoolRepo.findById(id).isPresent()) {
			SchoolEntity schoolEntity = schoolRepo.findById(id).get();
			schoolRepo.deleteById(id);
			return new ResponseEntity<SchoolEntity>(schoolEntity, HttpStatus.OK);
		} else {
			return new ResponseEntity<RESTError>(new RESTError(1, "School with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}
	}

}
