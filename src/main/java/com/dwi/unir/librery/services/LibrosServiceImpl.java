package com.dwi.unir.librery.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dwi.unir.librery.dao.ILibroDao;
import com.dwi.unir.librery.model.Libro;
import com.dwi.unir.librery.response.LibroResponseRest;

@Service
public class LibrosServiceImpl implements ILibroService{
	
	@Autowired
	private ILibroDao LibroDao;

	@Override
	@Transactional(readOnly=true)
	public ResponseEntity<LibroResponseRest> search() {
		
		LibroResponseRest response = new LibroResponseRest();
		
		try {
			List<Libro> libros = (List<Libro>) LibroDao.findAll();
			response.getLibroResponse().setLibro(libros);
			response.setMetadata("Respuesta Ok", "00", "Respuesta existosa");
		}
		catch(Exception e) {
			response.setMetadata("Respuesta nOk", "-1", "Error al consultar libros");
			e.getStackTrace();
			return new ResponseEntity<LibroResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<LibroResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional(readOnly= true)
	public ResponseEntity<LibroResponseRest> searchById(Long id) {
		
		LibroResponseRest response = new LibroResponseRest();
		List<Libro> list = new ArrayList<>();
		
		try {
			Optional<Libro> libro =LibroDao.findById(id);
			if (libro.isPresent()) {
				list.add(libro.get());
				response.getLibroResponse().setLibro(list);
				response.setMetadata("Respuesta ok", "00", "Libro encontrado");
			}
			else {
				response.setMetadata("Respuesta nok", "-1", "Libro no encontrado");
				return new  ResponseEntity<LibroResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al consultar por id de libro");
			e.getStackTrace();
			return new ResponseEntity<LibroResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<LibroResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<LibroResponseRest> save(Libro libro) {
		
		LibroResponseRest response = new LibroResponseRest();
		List<Libro> list = new ArrayList<>();
		
		try {
			
			Libro librosaved = LibroDao.save(libro);
			if(librosaved != null) {
				list.add(librosaved);
				response.getLibroResponse().setLibro(list);
				response.setMetadata("Respuesta Ok", "00", "Libro guardado con éxito");
			}
			else {
				response.setMetadata("Respuesta nOk", "-1", "Libro no guardado ");
				return new ResponseEntity<LibroResponseRest>(response, HttpStatus.BAD_REQUEST);
			}			
		}
		catch (Exception e) {
			response.setMetadata("Respuesta nOk", "-1", "Error al grabar el libro");
			e.getStackTrace();
			return new ResponseEntity<LibroResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<LibroResponseRest>(response, HttpStatus.OK);
		
	}

	@Override
	@Transactional
	public ResponseEntity<LibroResponseRest> update(Libro libro, Long id) {
		
		LibroResponseRest response = new LibroResponseRest();
		List<Libro> list = new ArrayList<>();
		
		try {
			Optional <Libro> libroSearch = LibroDao.findById(id);
			if (libroSearch.isPresent()) {
				
				libroSearch.get().setDescripcion(libro.getDescripcion());
				libroSearch.get().setFecha_publicacion(libro.getFecha_publicacion());
				libroSearch.get().setId_autor(libro.getId_autor());
				libroSearch.get().setId_categoria(libro.getId_categoria());
				libroSearch.get().setId_editorial(libro.getId_editorial());
				libroSearch.get().setIdioma(libro.getIdioma());
				libroSearch.get().setIsbn(libro.getIsbn());
				libroSearch.get().setNum_paginas(libro.getNum_paginas());
				libroSearch.get().setPortadaUrl(libro.getPortadaUrl());
				libroSearch.get().setPrecio(libro.getPrecio());
				libroSearch.get().setStock(libro.getStock());
				libroSearch.get().setTitulo(libro.getTitulo());
				
				Libro libroToUpdate = LibroDao.save(libroSearch.get());
				
				if(libroToUpdate != null) {
					list.add(libroToUpdate);
					response.setMetadata("Respuesta Ok", "00", "Libro actualizado");
				}
				else {
					response.setMetadata("Respuesta nOk", "-1", "Libro no actualizado");
					return new ResponseEntity<LibroResponseRest>(response, HttpStatus.BAD_REQUEST);
				}
			}
			else {
				response.setMetadata("Respuesta nOk", "-1", "Libro no encontrado");
				return new ResponseEntity<LibroResponseRest>(response, HttpStatus.NOT_FOUND);
			}				
		}
		catch (Exception e) {
			response.setMetadata("Respuesta nOk", "-1", "Error al actualizar el libro");
			e.getStackTrace();
			return new ResponseEntity<LibroResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<LibroResponseRest>(response, HttpStatus.OK);
		
	}

	@Override
	@Transactional
	public ResponseEntity<LibroResponseRest> deleteById(Long id) {
			
		LibroResponseRest response = new LibroResponseRest();
		
		try {
			LibroDao.deleteById(id);
			response.setMetadata("Respuesta ok", "00", "Registro eliminado con éxito");
		}
		catch(Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al eliminar el libro");
			e.getStackTrace();
			return new  ResponseEntity<LibroResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new  ResponseEntity<LibroResponseRest>(response, HttpStatus.OK);
	}
}