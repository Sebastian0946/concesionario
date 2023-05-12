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

import com.sena.concesionario.Entity.Modules;
import com.sena.concesionario.IService.IModulesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/security/modules")
public class ModulesController {

	@Autowired
	private IModulesService service;
	
	@GetMapping
	public List<Modules> all() {
		return service.all();
	}
	
	@GetMapping("{id}")
	public Optional<Modules> show(@PathVariable Integer id) {
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Modules save(@RequestBody Modules modules) {
		return service.save(modules);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Modules update(@PathVariable Integer id, @RequestBody Modules modules) {
		Optional<Modules> op = service.findById(id);
		
		if (!op.isEmpty()) {
			Modules modulesUpdate = op.get();
			modulesUpdate.setCode(modules.getCode());	
			modulesUpdate.setDescription(modules.getDescription());
			modulesUpdate.setState(modules.getState());
			modulesUpdate.setUserCreation(modules.getUserCreation());
			modulesUpdate.setUserModification(modules.getUserModification());
			modulesUpdate.setUserModification(modules.getUserModification());
			modulesUpdate.setModificationDate(modules.getModificationDate());
			return service.save(modulesUpdate);
		}
		
		return modules;
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
