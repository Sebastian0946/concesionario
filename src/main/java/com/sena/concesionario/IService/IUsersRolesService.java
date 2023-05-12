package com.sena.concesionario.IService;

import java.util.List;
import java.util.Optional;

import com.sena.concesionario.Entity.UsersRoles;

public interface IUsersRolesService {
	
	public List<UsersRoles> all();
    
	public Optional<UsersRoles> findById(Integer id);
	    
	public UsersRoles save(UsersRoles usersRoles);
	    
	public void delete(Integer id);
}
