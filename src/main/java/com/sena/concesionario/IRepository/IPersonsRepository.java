package com.sena.concesionario.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.concesionario.Entity.Persons;

public interface IPersonsRepository extends JpaRepository<Persons, Integer>{

}
