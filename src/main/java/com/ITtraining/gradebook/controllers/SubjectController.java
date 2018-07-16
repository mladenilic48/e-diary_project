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
import com.ITtraining.gradebook.entities.SubjectEntity;
import com.ITtraining.gradebook.repositories.SubjectRepository;

@RestController
@RequestMapping(value = "/api/v1/gradebook/subjects")
public class SubjectController {

	@Autowired
	private SubjectRepository subjectRepo;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getSubjects() {
		return new ResponseEntity<Iterable<SubjectEntity>>(subjectRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> getSubjectById(@PathVariable Integer id) {

		if (subjectRepo.findById(id).isPresent()) {
			return new ResponseEntity<SubjectEntity>(subjectRepo.findById(id).get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<RESTError>(new RESTError(1, "Subject with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addSubject(@RequestBody SubjectEntity newSubject) {

		if (newSubject == null || newSubject.getName() == null) {
			return new ResponseEntity<RESTError>(new RESTError(2, "Subject object is invalid."),
					HttpStatus.BAD_REQUEST);
		}

		SubjectEntity subjectEntity = new SubjectEntity();
		subjectEntity.setName(newSubject.getName());
		subjectEntity.setTeachingLoad(newSubject.getTeachingLoad());

		return new ResponseEntity<SubjectEntity>(subjectRepo.save(subjectEntity), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<?> updateSubject(@PathVariable Integer id, @RequestBody SubjectEntity updateSubject) {

		if (!subjectRepo.existsById(id)) {
			return new ResponseEntity<RESTError>(new RESTError(1, "Subject with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}

		SubjectEntity subjectEntity = subjectRepo.findById(id).get();

		if (updateSubject.getName() != null && !updateSubject.getName().equals("")
				&& !updateSubject.getName().equals(" ")) {
			subjectEntity.setName(updateSubject.getName());
		}

		if (updateSubject.getTeachingLoad() != null) {
			subjectEntity.setTeachingLoad(updateSubject.getTeachingLoad());
		}

		return new ResponseEntity<SubjectEntity>(subjectRepo.save(subjectEntity), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteSubject(@PathVariable Integer id) {

		if (subjectRepo.findById(id).isPresent()) {
			//SubjectEntity subjectEntity = subjectRepo.findById(id).get();
			subjectRepo.deleteById(id);
			// return new ResponseEntity<SubjectEntity>(subjectEntity, HttpStatus.OK);
			return new ResponseEntity<RESTError>(new RESTError(3, "Subject deleted."), HttpStatus.OK);
		} else {
			return new ResponseEntity<RESTError>(new RESTError(1, "Subject with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}
	}
}
