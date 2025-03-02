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

import com.dwi.unir.librery.model.Libro;
import com.dwi.unir.librery.response.LibroResponseRest;
import com.dwi.unir.librery.services.ILibroService;

@RestController
@RequestMapping("/api/librery")
@CrossOrigin(origins = "http://localhost:3000") 
public class LibroRestController {
	
	@Autowired
	private ILibroService service;
	
	/**
	 * 
	 * get all books from table libros
	 * 
	 * @return
	 */
	@GetMapping("/libros")
	public ResponseEntity<LibroResponseRest> searchLibro(){
		ResponseEntity<LibroResponseRest> response = service.search();
		return response;
	}
	
	/**
	 * 
	 * get book by id in the table libros
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/libros/{id}")
	public ResponseEntity<LibroResponseRest> searchLibroById(@PathVariable Long id){
		ResponseEntity<LibroResponseRest> response = service.searchById(id);
		return response;
	}
	
	/**
	 * 
	 * save the book in the table libros
	 * 
	 * @param libro
	 * @return
	 */
	@PostMapping("/libros")
	public ResponseEntity<LibroResponseRest> save(@RequestBody Libro libro){
		ResponseEntity<LibroResponseRest> response = service.save(libro);
		return response;
	}
	
	
	/**
	 * 
	 * update the book in the table libros
	 * 
	 * @param libro
	 * @param id
	 * @return
	 */
	@PutMapping("/libros/{id}")
	public ResponseEntity<LibroResponseRest> update (@RequestBody Libro libro,@PathVariable Long id){
		ResponseEntity<LibroResponseRest> response = service.update(libro,id);
		return response;		
	}
	
	
	/**
	 * 
	 * delete book by id in the table Libros
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/libros/{id}")
	public ResponseEntity<LibroResponseRest> delete(@PathVariable Long id){
		ResponseEntity<LibroResponseRest> response = service.deleteById(id);
		return response;
	}

}
