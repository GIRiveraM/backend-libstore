package com.unir.librery.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unir.librery.dao.IAutorDao;
import com.unir.librery.model.Autor;
import com.unir.librery.response.AutorResponseRest;



@Service
public class AutorServiceImpl implements IAutorService{

	@Autowired
	private IAutorDao AutorDao;

	@Override
	@Transactional(readOnly= true)
	public ResponseEntity<AutorResponseRest> search() {
		
		AutorResponseRest response = new AutorResponseRest();
		
		try 
		{
			List<Autor> autores = (List<Autor>) AutorDao.findAll();
			response.getAutorResponse().setAutor(autores);
			response.setMetadata("Respuesta Ok", "00", "Respuesta existosa");
		}
		catch(Exception e) 
		{
			response.setMetadata("Respuesta noK", "-1","Error al consultar autores");
			e.getStackTrace();
			return new ResponseEntity<AutorResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		
		return new ResponseEntity<AutorResponseRest>(response,HttpStatus.OK);
	}

	@Override
	@Transactional(readOnly= true)
	public ResponseEntity<AutorResponseRest> searchById(Long id) {
		
		AutorResponseRest response = new AutorResponseRest();
		List<Autor> list = new ArrayList<>();
		
		try {
			Optional <Autor> autor = AutorDao.findById(id);
			if(autor.isPresent()) {
				list.add(autor.get());
				response.getAutorResponse().setAutor(list);
				response.setMetadata("Respuesta ok", "00", "Autor encontrado");
			} 
			else {
				response.setMetadata("Respuesta nok", "-1", "Autor no encontrado");
				return new ResponseEntity<AutorResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		}		
		catch(Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al consultar por id del autor");
			e.getStackTrace();
			return new ResponseEntity<AutorResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new  ResponseEntity<AutorResponseRest>(response,HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<AutorResponseRest> save(Autor autor) {
		
		AutorResponseRest response = new AutorResponseRest();
		List<Autor> list = new ArrayList<>();
		
		try {
			Autor autorSaved = AutorDao.save(autor);
			if (autorSaved != null){
				list.add(autorSaved);
				response.getAutorResponse().setAutor(list);
				response.setMetadata("Respuesta Ok", "00", "Autor guardado con éxito");
			}
			else {
				response.setMetadata("Respuesta nOk", "-1", "Autor no  guardado");
				return new ResponseEntity<AutorResponseRest>(response,HttpStatus.BAD_REQUEST);
			}
		}
		catch (Exception e) {
			response.setMetadata("Respuesta nOk", "-1", "Error al grabar el autor");
			e.getStackTrace();
			return new ResponseEntity<AutorResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<AutorResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<AutorResponseRest> update(Autor autor, Long id) {
		AutorResponseRest response = new AutorResponseRest();
		List<Autor> list = new ArrayList<>();
		
		try {
			Optional <Autor> autorSearch = AutorDao.findById(id);
			if (autorSearch.isPresent()){
				
				autorSearch.get().setApellido(autor.getApellido());
				autorSearch.get().setBiografia(autor.getBiografia());
				autorSearch.get().setNacionalidad(autor.getNacionalidad());
				autorSearch.get().setNombre(autor.getNombre());
				
				Autor autorToupdate = AutorDao.save(autorSearch.get());
				
				if (autorToupdate != null){
					list.add(autorToupdate);
					response.getAutorResponse().setAutor(list);
					response.setMetadata("Respuesta Ok", "00", "Autor actualizado");
				}
				else {
					response.setMetadata("Respuesta nok", "-1", "Actor no actualizado");
					return new ResponseEntity<AutorResponseRest>(response, HttpStatus.BAD_REQUEST);
				}
			}
			else {
				response.setMetadata("Respuesta nok", "-1", "Actor no encontrado");
				return new ResponseEntity<AutorResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		}
		catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al actualizar el autor");
			e.getStackTrace();
			return new ResponseEntity<AutorResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<AutorResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<AutorResponseRest> deletebyId(Long id) {
		
		AutorResponseRest response = new AutorResponseRest();
		
		try {
			
			AutorDao.deleteById(id);
			response.setMetadata("Respuesta ok", "00", "Registro eliminado con éxito");			
		}
		catch (Exception e){
			response.setMetadata("Respuesta nok", "-1", "Error al eliminar el autor");
			e.getStackTrace();
			return new ResponseEntity<AutorResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<AutorResponseRest>(response, HttpStatus.OK);
	}
	
	
	
	
	
}
