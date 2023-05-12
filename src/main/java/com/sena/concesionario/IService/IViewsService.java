package com.sena.concesionario.IService;

import java.util.List;
import java.util.Optional;

import com.sena.concesionario.Entity.Views;

public interface IViewsService {

	public List<Views> all();
    
	public Optional<Views> findById(Integer id);
	    
	public Views save(Views vistas);
	    
	public void delete(Integer id);
}
