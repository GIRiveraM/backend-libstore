package com.dwi.unir.librery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dwi.unir.librery.model.Autor;
import com.dwi.unir.librery.response.AutorResponseRest;
import com.dwi.unir.librery.services.IAutorService;

@RestController
@RequestMapping("/api/librery")
@CrossOrigin(origins = "http://localhost:3000")
public class AutorRestController {
	
	@Autowired
	private IAutorService service;
	
	/**
	 * 
	 * get all autores of the table autores
	 * 
	 * @return
	 */
	@GetMapping("/autores")
	public ResponseEntity<AutorResponseRest> searchAutores() {
		ResponseEntity<AutorResponseRest> response = service.search();
		return response; // return value 
	} 
	
	
	/**
	 * 
	 * get autor by id in the table autores
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/autores/{id}")
	public ResponseEntity<AutorResponseRest> searchAutorById(@PathVariable Long id){
		ResponseEntity<AutorResponseRest> response = service.searchById(id);
		return response;
	}
	
	
	/**
	 * 
	 * save autor in the table autores
	 * 
	 * @param autor
	 * @return
	 */
	@PostMapping("/autores")
	public ResponseEntity<AutorResponseRest> save(@RequestBody Autor autor){
		ResponseEntity<AutorResponseRest> response = service.save(autor);
		return response;
	}
	
	
	/**
	 * 
	 * update autor in the table autores
	 * 	
	 * @param autor
	 * @param id
	 * @return
	 */
	@PutMapping("/autores/{id}")
	public ResponseEntity<AutorResponseRest> update(@RequestBody Autor autor,@PathVariable Long id){
		ResponseEntity<AutorResponseRest> response = service.update(autor, id);
		return response;
	}
	
	/**
	 * 
	 * delete an autor in the table autores
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/autores/{id}")
	public ResponseEntity<AutorResponseRest> delete(@PathVariable Long id){
		ResponseEntity<AutorResponseRest> response = service.deletebyId(id);
		return response;
	}
}
