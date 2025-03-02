package com.dwi.unir.librery.dao;

import org.springframework.data.repository.CrudRepository;

import com.dwi.unir.librery.model.Categoria;

public interface ICategoriaDao extends CrudRepository<Categoria, Long> {

}
