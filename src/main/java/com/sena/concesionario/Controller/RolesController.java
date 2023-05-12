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

import com.sena.concesionario.Entity.Roles;
import com.sena.concesionario.IService.IRolesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/security/roles")

public class RolesController {

	@Autowired
	private IRolesService service;
	
	@GetMapping
	public List<Roles> all() {
		return service.all();
	}
	
	@GetMapping("{id}")
	public Optional<Roles> show(@PathVariable Integer id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Roles save(@RequestBody Roles roles) {
		return service.save(roles);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Roles update(@PathVariable Integer id, @RequestBody Roles roles) {
		Optional<Roles> op = service.findById(id);
		
		if (!op.isEmpty()) {
			Roles rolesUpdate = op.get();
			rolesUpdate.setCode(roles.getCode());	
			rolesUpdate.setDescription(roles.getDescription());
			rolesUpdate.setState(roles.getState());
			rolesUpdate.setUserCreation(roles.getUserCreation());
			rolesUpdate.setUserModification(roles.getUserModification());
			rolesUpdate.setCreationDate(roles.getCreationDate());
			rolesUpdate.setModificationDate(roles.getModificationDate());
			return service.save(rolesUpdate);
		}
		
		return roles;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
}
