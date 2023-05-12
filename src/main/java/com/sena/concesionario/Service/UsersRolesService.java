package com.sena.concesionario.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.concesionario.Entity.UsersRoles;
import com.sena.concesionario.IRepository.IUsersRolesRepository;
import com.sena.concesionario.IService.IUsersRolesService;



@Service 
public class UsersRolesService implements IUsersRolesService{

	@Autowired
	private IUsersRolesRepository repository;
	
	@Override
	public List<UsersRoles> all() {
		return repository.findAll();
	}

	@Override
	public Optional<UsersRoles> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public UsersRoles save(UsersRoles userRoles) {
		return repository.save(userRoles);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

}
