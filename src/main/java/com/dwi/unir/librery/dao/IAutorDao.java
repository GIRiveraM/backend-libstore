package com.dwi.unir.librery.dao;

import org.springframework.data.repository.CrudRepository;

import com.dwi.unir.librery.model.Autor;

public interface IAutorDao extends CrudRepository<Autor, Long> {

}
