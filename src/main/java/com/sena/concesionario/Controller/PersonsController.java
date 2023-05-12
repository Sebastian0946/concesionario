package com.sena.concesionario.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sena.concesionario.Entity.Persons;
import com.sena.concesionario.IService.IPersonsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/security/persons")

public class PersonsController {
	
	@Autowired
	private IPersonsService service;

	@GetMapping
	public List<Persons> all() {
		return service.all();
	}

	@GetMapping("{id}")
	public Optional<Persons> show(@PathVariable Integer id) {
		return service.findById(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Persons save(@RequestBody Persons persons) {
		return service.save(persons);
	}

	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Persons update(@PathVariable Integer id, @RequestBody Persons persons) {
		Optional<Persons> op = service.findById(id);

		if (!op.isEmpty()) {
			Persons personsUpdate = op.get();
			
			personsUpdate.setDocumentType(persons.getDocumentType());
			personsUpdate.setDocument(persons.getDocument());
			personsUpdate.setFirstName(persons.getFirstName());
			personsUpdate.setSecondName(persons.getSecondName());
			personsUpdate.setSurName(persons.getSurName());
			personsUpdate.setSecondSurname(persons.getSecondSurname());
			personsUpdate.setAge(persons.getAge());
			personsUpdate.setGender(persons.getGender());
			personsUpdate.setEmail(persons.getEmail());
			personsUpdate.setPhone(persons.getPhone());
			personsUpdate.setAddress(persons.getAddress());
			personsUpdate.setState(persons.getState());
			personsUpdate.setUserCreation(persons.getUserCreation());
			personsUpdate.setUserModification(persons.getUserModification());
			personsUpdate.setCreationDate(persons.getCreationDate());
			personsUpdate.setModificationDate(persons.getModificationDate());
			return service.save(personsUpdate);
		}
		return persons;
	}

	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}	
}