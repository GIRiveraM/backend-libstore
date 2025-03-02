package com.dwi.unir.librery.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dwi.unir.librery.dao.IEditorialDao;
import com.dwi.unir.librery.model.Editorial;
import com.dwi.unir.librery.response.EditorialResponseRest;

@Service
public class EditorialServiceImpl implements IEditorialService{
	
	@Autowired
	private IEditorialDao EditorialDao;

	@Override
	@Transactional(readOnly= true)
	public ResponseEntity<EditorialResponseRest> search() {
		
		EditorialResponseRest response = new EditorialResponseRest();
		
		try {
			List<Editorial> editorial = (List<Editorial>) EditorialDao.findAll();
			response.getEditorialResponse().setEditorial(editorial);
			response.setMetadata("Respuesta OK", "00", "Respuesta existosa");
		}
		catch (Exception e) {
			response.setMetadata("Respuesta nOK", "-1", "Error al consultar las editoriales");
			e.getStackTrace();
			return new ResponseEntity<EditorialResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		
		return new ResponseEntity<EditorialResponseRest>(response, HttpStatus.OK);
		
	}

	@Override
	@Transactional(readOnly= true)
	public ResponseEntity<EditorialResponseRest> searchById(Long id) {
		
		EditorialResponseRest response = new EditorialResponseRest();
		List<Editorial> list = new ArrayList<>();
		
		try {
			Optional<Editorial> editorial = EditorialDao.findById(id);
			if (editorial.isPresent()) {
				list.add(editorial.get());
				response.getEditorialResponse().setEditorial(list);
				response.setMetadata("Respuesta OK", "00", "Editorial encontrada");
			}
			else {
				response.setMetadata("Respuesta nOK", "-1", "Editorial no encontrada");
				return new ResponseEntity<EditorialResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		}
		catch (Exception e) {
			response.setMetadata("Respuesta nOK", "-1", "Error al consultar por id de la editorial");
			e.getStackTrace();
			return new ResponseEntity<EditorialResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<EditorialResponseRest>(response, HttpStatus.OK);
		
	}

	@Override
	@Transactional
	public ResponseEntity<EditorialResponseRest> save(Editorial editorial) {
		
		EditorialResponseRest response = new EditorialResponseRest();
		List<Editorial> list = new ArrayList<>();
		
		try {
			Editorial editorialSaved = EditorialDao.save(editorial);
			if (editorialSaved != null){
				list.add(editorialSaved);
				response.getEditorialResponse().setEditorial(list);
				response.setMetadata("Respuesta OK", "00", "Editorial guardada con exito");
			}
			else {
				response.setMetadata("Respuesta nOK", "-1", "Editorial no guardada");
				return new ResponseEntity<EditorialResponseRest>(response, HttpStatus.BAD_REQUEST);
			}
		}
		catch (Exception e) {
			response.setMetadata("Respuesta nOK", "-1", "Error al grabar la editorial");
			e.getStackTrace();
			return new ResponseEntity<EditorialResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<EditorialResponseRest>(response, HttpStatus.OK);
		
	}

	@Override
	@Transactional
	public ResponseEntity<EditorialResponseRest> update(Editorial editorial, Long id) {
		
		EditorialResponseRest response = new EditorialResponseRest();
		List<Editorial> list = new ArrayList<>();
		
		try{
			Optional<Editorial> editorialSearch = EditorialDao.findById(id);
			if (editorialSearch.isPresent()){
				
				editorialSearch.get().setNombre(editorial.getNombre());
				editorialSearch.get().setPais(editorial.getPais());
				editorialSearch.get().setSitio_web(editorial.getSitio_web());
				
				Editorial editorialToUpdate = EditorialDao.save(editorialSearch.get());
				
				if (editorialToUpdate != null ){
					list.add(editorialToUpdate);
					response.getEditorialResponse().setEditorial(list);
					response.setMetadata("Respuesta OK", "00", "Editorial actualizada");
				}
				else {
					response.setMetadata("Respuesta nOK", "-1", "Editorial no actualizada");
					return new ResponseEntity<EditorialResponseRest>(response, HttpStatus.BAD_REQUEST);
				}
				
			}
			else {
				response.setMetadata("Respuesta nOK", "-1", "Editorial no encontrada");
				return new ResponseEntity<EditorialResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e) {
			response.setMetadata("Respuesta nOK", "-1", "Error al actualizar la editorial");
			e.getStackTrace();
			return new ResponseEntity<EditorialResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<EditorialResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<EditorialResponseRest> deleteById(Long id) {
		
		EditorialResponseRest response = new EditorialResponseRest();
		
		try {
			EditorialDao.deleteById(id);
			response.setMetadata("Respuesta OK", "00", "Editorial eliminada con éxito");
		}
		catch(Exception e) {
			response.setMetadata("Respuesta nOK", "-1", "Error al eliminar la editorial");
			e.getStackTrace();
			return new ResponseEntity<EditorialResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<EditorialResponseRest>(response, HttpStatus.OK);
	}

}
