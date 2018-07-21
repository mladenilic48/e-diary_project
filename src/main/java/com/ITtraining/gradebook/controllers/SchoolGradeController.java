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
import com.ITtraining.gradebook.entities.SchoolGradeEntity;
import com.ITtraining.gradebook.repositories.SchoolGradeRepository;

@RestController
@RequestMapping(value = "/api/v1/gradebook/school-grade")
public class SchoolGradeController {

	@Autowired
	private SchoolGradeRepository schoolGradeRepo;

	@RequestMapping
	public ResponseEntity<?> getSchoolsGrade() {
		return new ResponseEntity<Iterable<SchoolGradeEntity>>(schoolGradeRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> getSchoolGrade(@PathVariable Integer id) {
		if (schoolGradeRepo.existsById(id)) {
			return new ResponseEntity<SchoolGradeEntity>(schoolGradeRepo.findById(id).get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<RESTError>(new RESTError(1, "School grade with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addSchoolGrade(@RequestBody SchoolGradeEntity newSchoolGrade) {
		if (newSchoolGrade.getSchoolGrade() == null) {
			return new ResponseEntity<RESTError>(new RESTError(2, "School grade object is invalid."),
					HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<SchoolGradeEntity>(schoolGradeRepo.save(newSchoolGrade), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<?> updateSchoolGrade(@PathVariable Integer id,
			@RequestBody SchoolGradeEntity updatedSchoolGrade) {
		if (updatedSchoolGrade.getSchoolGrade() == null) {
			return new ResponseEntity<RESTError>(new RESTError(2, "School grade object is invalid."),
					HttpStatus.BAD_REQUEST);
		}

		if (!schoolGradeRepo.existsById(id)) {
			return new ResponseEntity<RESTError>(new RESTError(1, "School grade with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}

		SchoolGradeEntity schoolGradeEntity = schoolGradeRepo.findById(id).get();
		schoolGradeEntity.setSchoolGrade(updatedSchoolGrade.getSchoolGrade());

		return new ResponseEntity<SchoolGradeEntity>(schoolGradeRepo.save(schoolGradeEntity), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteSchoolGrade(@PathVariable Integer id) {
		if (schoolGradeRepo.existsById(id)) {
			SchoolGradeEntity schoolGradeEntity = schoolGradeRepo.findById(id).get();
			schoolGradeRepo.deleteById(id);
			return new ResponseEntity<SchoolGradeEntity>(schoolGradeEntity, HttpStatus.OK);
		} else {
			return new ResponseEntity<RESTError>(new RESTError(1, "School grade with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}
	}

}
