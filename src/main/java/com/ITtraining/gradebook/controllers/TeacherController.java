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
import com.ITtraining.gradebook.entities.TeacherEntity;
import com.ITtraining.gradebook.entities.dto.TeacherDTO;
import com.ITtraining.gradebook.repositories.TeacherRepository;

@RestController
@RequestMapping(value = "/api/v1/gradebook/teachers")
public class TeacherController {

	@Autowired
	private TeacherRepository teacherRepo;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getTeachers() {
		return new ResponseEntity<Iterable<TeacherEntity>>(teacherRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> getTeacherById(@PathVariable Integer id) {

		if (teacherRepo.findById(id).isPresent()) {
			return new ResponseEntity<TeacherEntity>(teacherRepo.findById(id).get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<RESTError>(new RESTError(1, "Teacher with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addTeacher(@RequestBody TeacherDTO newTeacher) {

		if (newTeacher == null) {
			return new ResponseEntity<RESTError>(new RESTError(2, "Teacher object is invalid."),
					HttpStatus.BAD_REQUEST);
		}

		if (newTeacher.getName() == null || newTeacher.getSurname() == null || newTeacher.getUsername() == null
				|| newTeacher.getPassword() == null) {
			return new ResponseEntity<RESTError>(new RESTError(2, "Teacher object is invalid."),
					HttpStatus.BAD_REQUEST);
		}

		TeacherEntity teacherEntity = new TeacherEntity();
		teacherEntity.setName(newTeacher.getName());
		teacherEntity.setSurname(newTeacher.getSurname());
		teacherEntity.setUsername(newTeacher.getUsername());
		teacherEntity.setPassword(newTeacher.getPassword());
		teacherEntity.setVocation(newTeacher.getVocation());

		return new ResponseEntity<TeacherEntity>(teacherRepo.save(teacherEntity), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<?> updateTeacher(@PathVariable Integer id, @RequestBody TeacherDTO updatedTeacher) {

		if (!teacherRepo.existsById(id)) {
			return new ResponseEntity<RESTError>(new RESTError(1, "Teacher with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}

		TeacherEntity teacherEntity = teacherRepo.findById(id).get();

		if (updatedTeacher.getName() != null && !updatedTeacher.getName().equals("")
				&& !updatedTeacher.getName().equals(" ")) {
			teacherEntity.setName(updatedTeacher.getName());
		}

		if (updatedTeacher.getSurname() != null && !updatedTeacher.getSurname().equals("")
				&& !updatedTeacher.getSurname().equals(" ")) {
			teacherEntity.setSurname(updatedTeacher.getSurname());
		}

		if (updatedTeacher.getUsername() != null && !updatedTeacher.getUsername().equals("")
				&& !updatedTeacher.getUsername().equals(" ")) {
			teacherEntity.setUsername(updatedTeacher.getUsername());
		}

		if (updatedTeacher.getVocation() != null && !updatedTeacher.getVocation().equals("")
				&& !updatedTeacher.getVocation().equals(" ")) {
			teacherEntity.setVocation(updatedTeacher.getVocation());
		}

		return new ResponseEntity<TeacherEntity>(teacherRepo.save(teacherEntity), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteTeacher(@PathVariable Integer id) {

		if (teacherRepo.findById(id).isPresent()) {
			TeacherEntity teacherEntity = teacherRepo.findById(id).get();
			teacherRepo.deleteById(id);			
			return new ResponseEntity<TeacherEntity>(teacherEntity, HttpStatus.OK);
		} else {
			return new ResponseEntity<RESTError>(new RESTError(1, "Teacher with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}
	}

}
