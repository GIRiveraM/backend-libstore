package com.unir.librery.dao;

import org.springframework.data.repository.CrudRepository;

import com.unir.librery.model.Libro;

public interface ILibroDao extends CrudRepository<Libro, Long> {

}
