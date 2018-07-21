package com.ITtraining.gradebook.controllers;

import javax.validation.Valid;

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
import com.ITtraining.gradebook.entities.dto.ParentDTO;
import com.ITtraining.gradebook.repositories.ParentRepository;

@RestController
@RequestMapping(value = "/api/v1/gradebook/parents")
public class ParentController {

	@Autowired
	private ParentRepository parentRepo;

	private String createErrorMessage(BindingResult result) {
		String msg = " ";
		for (ObjectError error : result.getAllErrors()) {
			msg += error.getDefaultMessage();
			msg += " ";
		}
		return msg;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getParents() {
		return new ResponseEntity<Iterable<ParentEntity>>(parentRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}")
	public ResponseEntity<?> getParentById(@PathVariable Integer id) {

		if (parentRepo.findById(id).isPresent()) {
			return new ResponseEntity<ParentEntity>(parentRepo.findById(id).get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<RESTError>(new RESTError(1, "Parent with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addParent(@Valid @RequestBody ParentDTO newParent, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(createErrorMessage(result), HttpStatus.BAD_REQUEST);
		}

		ParentEntity parentEntity = new ParentEntity();
		parentEntity.setName(newParent.getName());
		parentEntity.setSurname(newParent.getSurname());
		parentEntity.setUsername(newParent.getUsername());
		parentEntity.setPassword(newParent.getPassword());
		parentEntity.setEmail(newParent.getEmail());

		return new ResponseEntity<ParentEntity>(parentRepo.save(parentEntity), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<?> updateParent(@PathVariable Integer id, @RequestBody ParentDTO updateParent) {
		if (!parentRepo.existsById(id)) {
			return new ResponseEntity<RESTError>(new RESTError(1, "Parent with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}

		ParentEntity parentEntity = parentRepo.findById(id).get();

		if (updateParent.getName() != null && !updateParent.getName().equals("")
				&& !updateParent.getName().equals(" ")) {
			parentEntity.setName(updateParent.getName());
		}

		if (updateParent.getSurname() != null && !updateParent.getSurname().equals("")
				&& !updateParent.getSurname().equals(" ")) {
			parentEntity.setSurname(updateParent.getSurname());
		}

		if (updateParent.getUsername() != null && !updateParent.getUsername().equals("")
				&& !updateParent.getUsername().equals(" ")) {
			parentEntity.setUsername(updateParent.getUsername());
		}

		if (updateParent.getEmail() != null && !updateParent.getEmail().equals("")
				&& !updateParent.getEmail().equals(" ")) {
			parentEntity.setEmail(updateParent.getEmail());
		}

		return new ResponseEntity<ParentEntity>(parentRepo.save(parentEntity), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<?> deleteParent(@PathVariable Integer id) {

		if (parentRepo.findById(id).isPresent()) {
			ParentEntity parentEntity = parentRepo.findById(id).get();
			parentRepo.deleteById(id);
			return new ResponseEntity<ParentEntity>(parentEntity, HttpStatus.OK);
		} else {
			return new ResponseEntity<RESTError>(new RESTError(1, "Parent with provided Id not found."),
					HttpStatus.NOT_FOUND);
		}
	}
}
