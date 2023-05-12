package com.sena.concesionario.IService;

import java.util.List;
import java.util.Optional;

import com.sena.concesionario.Entity.Users;

public interface IUsersService {
	
	public List<Users> all();
    
	public Optional<Users> findById(Integer id);
	    
	public Users save(Users users);
	    
	public void delete(Integer id);
}
