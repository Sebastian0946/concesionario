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

import com.sena.concesionario.Entity.Users;
import com.sena.concesionario.IService.IUsersService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/security/users")

public class UsersController {

	@Autowired
	private IUsersService service;

	@GetMapping
	public List<Users> all() {
		return service.all();
	}

	@GetMapping("{id}")
	public Optional<Users> show(@PathVariable Integer id) {
		return service.findById(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Users save(@RequestBody Users users) {
		return service.save(users);
	}

	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Users update(@PathVariable Integer id, @RequestBody Users users) {
		Optional<Users> op = service.findById(id);

		if (!op.isEmpty()) {
			Users usersUpdate = op.get();
			usersUpdate.setPersonId(users.getPersonId());
			usersUpdate.setUser(users.getUser());
			usersUpdate.setPassword(users.getPassword());
			usersUpdate.setState(users.getState());
			usersUpdate.setUserCreation(users.getUserCreation());
			usersUpdate.setUserModification(users.getUserModification());
			usersUpdate.setCreationDate(users.getCreationDate());
			usersUpdate.setModificationDate(users.getModificationDate());
			return service.save(usersUpdate);
		}

		return users;
	}

	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	

}
