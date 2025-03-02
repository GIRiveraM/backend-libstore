package com.unir.librery.dao;

import org.springframework.data.repository.CrudRepository;

import com.unir.librery.model.Categoria;

public interface ICategoriaDao extends CrudRepository<Categoria, Long> {

}
