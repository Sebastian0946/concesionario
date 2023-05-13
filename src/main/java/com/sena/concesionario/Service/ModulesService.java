package com.sena.concesionario.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.sena.concesionario.Entity.Modules;
import com.sena.concesionario.IRepository.IModulesRepository;
import com.sena.concesionario.IService.IModulesService;

@Service
@SpringBootApplication
public class ModulesService implements IModulesService{
	
	public String PORT = System.getenv("PATH");
	
	@Autowired
	private IModulesRepository repository;

	@Override
	public List<Modules> all() {
		return repository.findAll();
	}

	@Override
	public Optional<Modules> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Modules save(Modules modulos) {
		return repository.save(modulos);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);		
	}		
}
