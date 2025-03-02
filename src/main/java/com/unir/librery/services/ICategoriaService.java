package com.unir.librery.services;

import org.springframework.http.ResponseEntity;

import com.unir.librery.model.Categoria;
import com.unir.librery.response.CategoriaResponseRest;

public interface ICategoriaService {
	
	public ResponseEntity<CategoriaResponseRest> search();
	
	public ResponseEntity<CategoriaResponseRest> searchById(Long id);
	
	public ResponseEntity<CategoriaResponseRest> save(Categoria categoria);
	
	public ResponseEntity<CategoriaResponseRest> update(Categoria categoria, Long id);
	
	public ResponseEntity<CategoriaResponseRest> deleteById(Long id);

}
