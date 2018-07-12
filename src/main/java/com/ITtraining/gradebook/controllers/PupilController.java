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
import com.ITtraining.gradebook.entities.PupilEntity;
import com.ITtraining.gradebook.entities.dto.PupilDTO;
import com.ITtraining.gradebook.repositories.PupilRepository;

@RestController
@RequestMapping(value = "/api/v1/gradebook/pupils")
public class PupilController {

	@Autowired
	private PupilRepository pupilRepo;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getPupils() {
		return new ResponseEntity<Iterable<PupilEntity>>(pupilRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> getPupilById(@PathVariable Integer id) {

		if (pupilRepo.findById(id).isPresent()) {
			return new ResponseEntity<PupilEntity>(pupilRepo.findById(id).get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<RESTError>(new RESTError(1, "Pupil with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addPupil(@RequestBody PupilDTO newPupil) {

		if (newPupil == null) {
			return new ResponseEntity<RESTError>(new RESTError(2, "Pupil object is invalid."), HttpStatus.BAD_REQUEST);
		}

		if (newPupil.getName() == null || newPupil.getSurname() == null || newPupil.getUsername() == null
				|| newPupil.getPassword() == null || newPupil.getUniquePupilNumber() == null) {
			return new ResponseEntity<RESTError>(new RESTError(2, "Pupil object is invalid."), HttpStatus.BAD_REQUEST);
		}

		PupilEntity pupilEntity = new PupilEntity();
		pupilEntity.setName(newPupil.getName());
		pupilEntity.setSurname(newPupil.getSurname());
		pupilEntity.setUsername(newPupil.getUsername());
		pupilEntity.setPassword(newPupil.getPassword());
		pupilEntity.setUniquePupilNumber(newPupil.getUniquePupilNumber());
		pupilEntity.setSchoolClass(newPupil.getSchoolClass());
		pupilEntity.setClassNumber(newPupil.getClassNumber());

		return new ResponseEntity<PupilEntity>(pupilRepo.save(pupilEntity), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<?> updatePupil(@PathVariable Integer id, @RequestBody PupilDTO updatedPupil) {

		if (!pupilRepo.existsById(id)) {
			return new ResponseEntity<RESTError>(new RESTError(1, "Pupil with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}

		PupilEntity pupilEntity = pupilRepo.findById(id).get();

		if (updatedPupil.getName() != null && !updatedPupil.getName().equals("")
				&& !updatedPupil.getName().equals(" ")) {
			pupilEntity.setName(updatedPupil.getName());
		}

		if (updatedPupil.getSurname() != null && !updatedPupil.getSurname().equals("")
				&& !updatedPupil.getSurname().equals(" ")) {
			pupilEntity.setSurname(updatedPupil.getSurname());
		}

		if (updatedPupil.getUsername() != null && !updatedPupil.getUsername().equals("")
				&& !updatedPupil.getUsername().equals(" ")) {
			pupilEntity.setUsername(updatedPupil.getUsername());
		}

		if (updatedPupil.getUniquePupilNumber() != null && !updatedPupil.getUniquePupilNumber().equals("")
				&& !updatedPupil.getUniquePupilNumber().equals(" ")) {
			pupilEntity.setUniquePupilNumber(updatedPupil.getUniquePupilNumber());
		}

		if (updatedPupil.getSchoolClass() != null) {
			pupilEntity.setSchoolClass(updatedPupil.getSchoolClass());
		}

		if (updatedPupil.getClassNumber() != null) {
			pupilEntity.setClassNumber(updatedPupil.getClassNumber());
		}

		return new ResponseEntity<PupilEntity>(pupilRepo.save(pupilEntity), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deletePupil(@PathVariable Integer id) {

		if (pupilRepo.findById(id).isPresent()) {
			PupilEntity pupilEntity = pupilRepo.findById(id).get();
			pupilRepo.deleteById(id);
			return new ResponseEntity<PupilEntity>(pupilEntity, HttpStatus.OK);
		} else {
			return new ResponseEntity<RESTError>(new RESTError(1, "Pupil with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}
	}
}
