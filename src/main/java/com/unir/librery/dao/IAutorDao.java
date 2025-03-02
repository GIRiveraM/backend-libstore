package com.unir.librery.dao;

import org.springframework.data.repository.CrudRepository;

import com.unir.librery.model.Autor;

public interface IAutorDao extends CrudRepository<Autor, Long> {

}
