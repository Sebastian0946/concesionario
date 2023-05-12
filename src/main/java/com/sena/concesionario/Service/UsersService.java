package com.sena.concesionario.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.concesionario.Entity.Users;
import com.sena.concesionario.IRepository.IUsersRepository;
import com.sena.concesionario.IService.IUsersService;

@Service
public class UsersService implements IUsersService{
	
	@Autowired
	private IUsersRepository repository;

	@Override
	public List<Users> all() {
		return repository.findAll();
	}

	@Override
	public Optional<Users> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Users save(Users users) {
		return repository.save(users);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);		
	}
}
