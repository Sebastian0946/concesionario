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

import com.sena.concesionario.Entity.UsersRoles;
import com.sena.concesionario.IService.IUsersRolesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/security/usersRoles")

public class UsersRolesController {

	@Autowired
	private IUsersRolesService service;
	
	@GetMapping
	public List<UsersRoles> all() {
		return service.all();
	}
	
	@GetMapping("{id}")
	public Optional<UsersRoles> show(@PathVariable Integer id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public UsersRoles save(@RequestBody UsersRoles usersRoles) {
		return service.save(usersRoles);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public UsersRoles update(@PathVariable Integer id, @RequestBody UsersRoles usersRoles) {
		Optional<UsersRoles> op = service.findById(id);
		
		if (!op.isEmpty()) {
			UsersRoles usersRolesUpdate = op.get();
			usersRolesUpdate.setUserId(usersRoles.getUserId());
			usersRolesUpdate.setRolId(usersRoles.getRolId());
			usersRolesUpdate.setState(usersRoles.getState());
			usersRolesUpdate.setUserCreation(usersRoles.getUserCreation());
			usersRolesUpdate.setUserModification(usersRoles.getUserModification());
			usersRolesUpdate.setCreationDate(usersRoles.getCreationDate());
			usersRolesUpdate.setModificationDate(usersRoles.getModificationDate());
			return service.save(usersRolesUpdate);
		}
		
		return usersRoles;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
}
