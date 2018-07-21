package com.ITtraining.gradebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ITtraining.gradebook.controllers.util.RESTError;
import com.ITtraining.gradebook.entities.SchoolClassEntity;
import com.ITtraining.gradebook.repositories.SchoolClassRepository;
import com.ITtraining.gradebook.repositories.SchoolGradeRepository;

@RestController
@RequestMapping(value = "/api/v1/gradebook/school-class")
public class SchoolClassController {

	@Autowired
	private SchoolClassRepository schoolClassRepo;

	@Autowired
	private SchoolGradeRepository schoolGradeRepo;

	@RequestMapping
	public ResponseEntity<?> getSchoolClasses() {
		return new ResponseEntity<Iterable<SchoolClassEntity>>(schoolClassRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> getSchoolClass(@PathVariable Integer id) {
		if (schoolClassRepo.existsById(id)) {
			return new ResponseEntity<SchoolClassEntity>(schoolClassRepo.findById(id).get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<RESTError>(new RESTError(1, "School class with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/grade/{gradeId}")
	public ResponseEntity<?> addSchoolClass(@RequestBody SchoolClassEntity newSchoolClass,
			@PathVariable Integer gradeId) {
		if (newSchoolClass.getClassNumber() == null) {
			return new ResponseEntity<RESTError>(new RESTError(2, "School class object is invalid."),
					HttpStatus.BAD_REQUEST);
		}

		if (!schoolGradeRepo.existsById(gradeId)) {
			return new ResponseEntity<RESTError>(new RESTError(1, "School grade with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}

		newSchoolClass.setSchoolGrade(schoolGradeRepo.findById(gradeId).get());
		return new ResponseEntity<SchoolClassEntity>(schoolClassRepo.save(newSchoolClass), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<?> updateSchoolclass(@RequestParam Integer gradeId,
			@RequestBody SchoolClassEntity updatedSchoolClass, @PathVariable Integer id) {
		if (!schoolClassRepo.existsById(id)) {
			return new ResponseEntity<RESTError>(new RESTError(1, "School class with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}

		SchoolClassEntity schoolClassEntity = schoolClassRepo.findById(id).get();

		if (gradeId != null) {
			if (!schoolGradeRepo.existsById(gradeId)) {
				return new ResponseEntity<RESTError>(new RESTError(1, "School grade with provided Id not found."),
						HttpStatus.NOT_FOUND);
			} else {
				schoolClassEntity.setSchoolGrade(schoolGradeRepo.findById(gradeId).get());
			}
		}

		if (updatedSchoolClass.getClassNumber() == null) {
			return new ResponseEntity<RESTError>(new RESTError(2, "School class object is invalid."),
					HttpStatus.BAD_REQUEST);
		} else {
			schoolClassEntity.setClassNumber(updatedSchoolClass.getClassNumber());
		}

		return new ResponseEntity<SchoolClassEntity>(schoolClassRepo.save(schoolClassEntity), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteSchoolClass(@PathVariable Integer id) {
		if (schoolClassRepo.existsById(id)) {
			SchoolClassEntity schoolClassEntity = schoolClassRepo.findById(id).get();
			schoolClassRepo.deleteById(id);
			return new ResponseEntity<SchoolClassEntity>(schoolClassEntity, HttpStatus.OK);
		} else {
			return new ResponseEntity<RESTError>(new RESTError(1, "School class with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}
	}

}
