package com.unir.librery.services;

import org.springframework.http.ResponseEntity;

import com.unir.librery.model.Libro;
import com.unir.librery.response.LibroResponseRest;

public interface ILibroService 
{
	
	public ResponseEntity<LibroResponseRest> search();
	
	public ResponseEntity<LibroResponseRest> searchById(Long id);
	
	public ResponseEntity<LibroResponseRest> save(Libro libro);
	
	public ResponseEntity<LibroResponseRest> update(Libro libro, Long id);
	
	public ResponseEntity<LibroResponseRest> deleteById(Long id);
	
}
