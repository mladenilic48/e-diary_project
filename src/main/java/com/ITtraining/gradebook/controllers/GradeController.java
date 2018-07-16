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
import com.ITtraining.gradebook.entities.GradeEntity;
import com.ITtraining.gradebook.repositories.GradeRepository;

@RestController
@RequestMapping(value = "/api/v1/gradebook/grades")
public class GradeController {

	@Autowired
	private GradeRepository gradeRepo;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getGrades() {
		return new ResponseEntity<Iterable<GradeEntity>>(gradeRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> getGradeById(@PathVariable Integer id) {

		if (gradeRepo.findById(id).isPresent()) {
			return new ResponseEntity<GradeEntity>(gradeRepo.findById(id).get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<RESTError>(new RESTError(1, "Grade with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addGrade(@RequestBody GradeEntity newGrade) {

		if (newGrade == null || newGrade.getGrade() == null) {
			return new ResponseEntity<RESTError>(new RESTError(2, "Grade object is invalid."), HttpStatus.BAD_REQUEST);
		}

		GradeEntity gradeEntity = new GradeEntity();
		gradeEntity.setGrade(newGrade.getGrade());

		return new ResponseEntity<GradeEntity>(gradeRepo.save(gradeEntity), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<?> updateGrade(@PathVariable Integer id, @RequestBody GradeEntity updatedGrade) {

		if (!gradeRepo.existsById(id)) {
			return new ResponseEntity<RESTError>(new RESTError(1, "Grade with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}

		GradeEntity gradeEntity = gradeRepo.findById(id).get();

		if (updatedGrade.getGrade() != null) {
			gradeEntity.setGrade(updatedGrade.getGrade());
		}

		return new ResponseEntity<GradeEntity>(gradeRepo.save(gradeEntity), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteGrade(@PathVariable Integer id) {

		if (gradeRepo.findById(id).isPresent()) {
			GradeEntity gradeEntity = gradeRepo.findById(id).get();
			gradeRepo.deleteById(id);
			return new ResponseEntity<GradeEntity>(gradeEntity, HttpStatus.OK);
		} else {
			return new ResponseEntity<RESTError>(new RESTError(1, "Grade with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}
	}
}
