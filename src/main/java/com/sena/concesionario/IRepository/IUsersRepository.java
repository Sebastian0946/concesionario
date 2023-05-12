package com.sena.concesionario.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.concesionario.Entity.Users;

public interface IUsersRepository extends JpaRepository<Users, Integer>{

}