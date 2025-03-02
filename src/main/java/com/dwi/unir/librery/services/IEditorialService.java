package com.dwi.unir.librery.services;

import org.springframework.http.ResponseEntity;

import com.dwi.unir.librery.model.Editorial;
import com.dwi.unir.librery.response.EditorialResponseRest;

public interface IEditorialService {
	
	public ResponseEntity<EditorialResponseRest> search();
	
	public ResponseEntity<EditorialResponseRest> searchById(Long id);
	
	public ResponseEntity<EditorialResponseRest> save(Editorial editorial);
	
	public ResponseEntity<EditorialResponseRest> update(Editorial editorial, Long id);
	
	public ResponseEntity<EditorialResponseRest> deleteById(Long id);

}
