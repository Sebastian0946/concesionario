package com.sena.concesionario.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.concesionario.Entity.Views;
import com.sena.concesionario.IRepository.IViewsRepository;
import com.sena.concesionario.IService.IViewsService;

@Service
public class ViewsService implements IViewsService{
	
	@Autowired
	private IViewsRepository repository;

	@Override
	public List<Views> all() {		
		return repository.findAll();
	}

	@Override
	public Optional<Views> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Views save(Views vistas) {
		return repository.save(vistas);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}	
}
