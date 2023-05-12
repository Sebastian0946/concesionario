package com.sena.concesionario.IService;

import java.util.List;
import java.util.Optional;


import com.sena.concesionario.Entity.Persons;

public interface IPersonsService {
	
	public List<Persons> all();
    
	public Optional<Persons> findById(Integer id);
	    
	public Persons save(Persons person);
	    
	public void delete(Integer id);
}
