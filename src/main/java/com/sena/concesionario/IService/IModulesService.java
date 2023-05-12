package com.sena.concesionario.IService;

import java.util.List;
import java.util.Optional;

import com.sena.concesionario.Entity.Modules;


public interface IModulesService {
	
	public List<Modules> all();
    
	public Optional<Modules> findById(Integer id);
	    
	public Modules save(Modules modulos);
	    
	public void delete(Integer id);

}
