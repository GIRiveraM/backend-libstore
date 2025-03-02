package com.unir.librery.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.librery.model.Categoria;
import com.unir.librery.response.CategoriaResponseRest;
import com.unir.librery.services.ICategoriaService;

@RestController
@RequestMapping("/api/librery")
@CrossOrigin(origins = "http://localhost:3000") 
public class CategoriaRestController {

	@Autowired
	private ICategoriaService service;
	
	
	/**
	 * 
	 * get all category of the table categoria 
	 * 
	 * @return
	 */
	@GetMapping("/categorias")
	public ResponseEntity<CategoriaResponseRest> searchCategoria(){
		ResponseEntity<CategoriaResponseRest> response = service.search();
		return response;
	}
	
	/**
	 * 
	 * get category by id in the table categoria 
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/categorias/{id}")
	public ResponseEntity<CategoriaResponseRest> searchCategoriaById(@PathVariable Long id){
		ResponseEntity<CategoriaResponseRest>response = service.searchById(id);
		return response;
	}
	
	/**
	 * 
	 * save category in the table categorias
	 * 
	 * @param categoria
	 * @return
	 */
	@PostMapping("/categorias")
	public ResponseEntity<CategoriaResponseRest> save(@RequestBody Categoria categoria){
		ResponseEntity<CategoriaResponseRest>response = service.save(categoria);
		return response;
	}
	
	/**
	 * 
	 * update category in the table categoria
	 * 
	 * @param categoria
	 * @param id
	 * @return
	 */
	@PutMapping("/categorias/{id}")
	public ResponseEntity<CategoriaResponseRest> update(@RequestBody Categoria categoria,@PathVariable Long id){
		ResponseEntity<CategoriaResponseRest> response = service.update(categoria, id);
		return response;
	}
	
	/**
	 * 
	 * delete category by id in the table categoria
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/categorias/{id}")
	public ResponseEntity<CategoriaResponseRest> delete(@PathVariable Long id){
		ResponseEntity<CategoriaResponseRest> response = service.deleteById(id);
		return response;
	}
}
