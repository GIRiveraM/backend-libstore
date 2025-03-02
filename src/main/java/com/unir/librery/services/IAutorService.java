package com.unir.librery.services;

import org.springframework.http.ResponseEntity;

import com.unir.librery.model.Autor;
import com.unir.librery.response.AutorResponseRest;


public interface IAutorService
{
	public ResponseEntity<AutorResponseRest> search();
	
	public ResponseEntity<AutorResponseRest> searchById(Long id);
	
	public ResponseEntity<AutorResponseRest> save(Autor autor);
	
	public ResponseEntity<AutorResponseRest> update(Autor autor, Long id);
	
	public ResponseEntity<AutorResponseRest> deletebyId(Long id);
}
