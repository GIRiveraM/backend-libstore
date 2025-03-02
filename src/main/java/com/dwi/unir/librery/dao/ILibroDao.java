package com.dwi.unir.librery.dao;

import org.springframework.data.repository.CrudRepository;

import com.dwi.unir.librery.model.Libro;

public interface ILibroDao extends CrudRepository<Libro, Long> {

}
