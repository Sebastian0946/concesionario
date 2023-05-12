package com.sena.concesionario.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.concesionario.Entity.Persons;
import com.sena.concesionario.IRepository.IPersonsRepository;
import com.sena.concesionario.IService.IPersonsService;

@Service
public class PersonsService implements IPersonsService{

	@Autowired
	private IPersonsRepository repository;

	@Override
	public List<Persons> all() {		
		return repository.findAll();
	}

	@Override
	public Optional<Persons> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Persons save(Persons persons) {
		return repository.save(persons);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
}
