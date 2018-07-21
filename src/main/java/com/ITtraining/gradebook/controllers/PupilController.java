package com.ITtraining.gradebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ITtraining.gradebook.controllers.util.RESTError;
import com.ITtraining.gradebook.entities.ParentEntity;
import com.ITtraining.gradebook.entities.PupilEntity;
import com.ITtraining.gradebook.entities.SchoolClassEntity;
import com.ITtraining.gradebook.entities.SchoolEntity;
import com.ITtraining.gradebook.entities.dto.PupilDTO;
import com.ITtraining.gradebook.repositories.ParentRepository;
import com.ITtraining.gradebook.repositories.PupilRepository;
import com.ITtraining.gradebook.repositories.SchoolClassRepository;
import com.ITtraining.gradebook.repositories.SchoolRepository;

@RestController
@RequestMapping(value = "/api/v1/gradebook/pupils")
public class PupilController {

	@Autowired
	private PupilRepository pupilRepo;

	@Autowired
	private ParentRepository parentRepo;

	@Autowired
	private SchoolClassRepository schoolClassRepo;

	@Autowired
	private SchoolRepository schoolRepo;

	private String createErrorMessage(BindingResult result) {
		String msg = " ";
		for (ObjectError error : result.getAllErrors()) {
			msg += error.getDefaultMessage();
			msg += " ";
		}
		return msg;
	}

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

	@RequestMapping(method = RequestMethod.POST, value = "/parent/{parentId}/class/{classId}/school/{schoolId}")
	public ResponseEntity<?> addPupil(@RequestBody PupilDTO newPupil, BindingResult result,
			@PathVariable Integer parentId, @PathVariable Integer classId, @PathVariable Integer schoolId) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(createErrorMessage(result), HttpStatus.BAD_REQUEST);
		}

		PupilEntity pupilEntity = new PupilEntity();
		ParentEntity parentEntity = null;

		if (parentRepo.existsById(parentId)) {
			parentEntity = parentRepo.findById(parentId).get();
		} else {
			return new ResponseEntity<RESTError>(new RESTError(1, "Parent with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}

		if (!schoolClassRepo.existsById(classId)) {
			return new ResponseEntity<RESTError>(new RESTError(1, "School class with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}

		SchoolClassEntity schoolClassEntity = schoolClassRepo.findById(classId).get();

		if (!schoolRepo.existsById(schoolId)) {
			return new ResponseEntity<RESTError>(new RESTError(1, "School with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}

		SchoolEntity schoolEntity = schoolRepo.findById(schoolId).get();

		pupilEntity.setName(newPupil.getName());
		pupilEntity.setSurname(newPupil.getSurname());
		pupilEntity.setUsername(newPupil.getUsername());
		pupilEntity.setPassword(newPupil.getPassword());
		pupilEntity.setUniquePupilNumber(newPupil.getUniquePupilNumber());
		pupilEntity.setPupil_Parent(parentEntity);
		pupilEntity.setPupil_SchoolClass(schoolClassEntity);
		pupilEntity.setSchool(schoolEntity);

		return new ResponseEntity<PupilEntity>(pupilRepo.save(pupilEntity), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}/parent/{parentId}/class/{classId}/school/{schoolId}")
	public ResponseEntity<?> updatePupil(@PathVariable Integer id, @RequestBody PupilDTO updatedPupil,
			@PathVariable Integer parentId, @PathVariable Integer classId, @PathVariable Integer schoolId) {

		if (!pupilRepo.existsById(id)) {
			return new ResponseEntity<RESTError>(new RESTError(1, "Pupil with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}

		ParentEntity parentEntity = null;

		if (parentRepo.existsById(parentId)) {
			parentEntity = parentRepo.findById(parentId).get();
		} else {
			return new ResponseEntity<RESTError>(new RESTError(1, "Parent with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}

		if (!schoolClassRepo.existsById(classId)) {
			return new ResponseEntity<RESTError>(new RESTError(1, "School class with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}

		SchoolClassEntity schoolClassEntity = schoolClassRepo.findById(classId).get();

		if (!schoolRepo.existsById(schoolId)) {
			return new ResponseEntity<RESTError>(new RESTError(1, "School with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}

		SchoolEntity schoolEntity = schoolRepo.findById(schoolId).get();

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

		pupilEntity.setPupil_Parent(parentEntity);
		pupilEntity.setPupil_SchoolClass(schoolClassEntity);
		pupilEntity.setSchool(schoolEntity);

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
