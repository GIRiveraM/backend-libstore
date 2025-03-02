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
import com.dwi.unir.librery.model.Editorial;
import com.dwi.unir.librery.response.EditorialResponseRest;
import com.dwi.unir.librery.services.IEditorialService;

@RestController
@RequestMapping("/api/librery")
@CrossOrigin(origins = "http://localhost:3000") 
public class EditorialRestController {
	
	@Autowired
	private IEditorialService service;
	
	
	/**
	 * 
	 * get all editorial from table editoriales
	 * 
	 * @return
	 */
	@GetMapping("/editoriales")
	public ResponseEntity<EditorialResponseRest> searchEditorial(){
		ResponseEntity<EditorialResponseRest> response = service.search();
		return response;
	}
	
	
	/**
	 * 
	 * get Editorial by id from table Editoriales
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/editoriales/{id}")
	public ResponseEntity<EditorialResponseRest> searchEditorialById(@PathVariable Long id){
		ResponseEntity<EditorialResponseRest> response = service.searchById(id);
		return response;
	}
	
	
	/**
	 * 
	 * save the editorial in the table Editoriales
	 * 
	 * @param editorial
	 * @return
	 */
	@PostMapping("/editoriales")
	public ResponseEntity<EditorialResponseRest>save (@RequestBody Editorial editorial){
		ResponseEntity<EditorialResponseRest> response = service.save(editorial);
		return response;
	}
	
	
	/**
	 * 
	 * update editorial in the table editoriales
	 * 
	 * @param editorial
	 * @param id
	 * @return
	 */
	@PutMapping("/editoriales/{id}")
	public ResponseEntity<EditorialResponseRest> update (@RequestBody Editorial editorial,@PathVariable Long id){
		ResponseEntity<EditorialResponseRest> response = service.update(editorial, id);
		return response;
	}
	
	
	/**
	 * 
	 * delete editorial by id in the table Editorial
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/editoriales/{id}")
	public ResponseEntity<EditorialResponseRest> delete(@PathVariable Long id){
		ResponseEntity<EditorialResponseRest> response = service.deleteById(id);
		return response;
	}
}
