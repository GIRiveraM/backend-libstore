package com.unir.librery.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unir.librery.dao.ICategoriaDao;
import com.unir.librery.model.Categoria;
import com.unir.librery.response.CategoriaResponseRest;



@Service
public class CategoriaServiceImpl implements ICategoriaService{
	
	@Autowired
	private ICategoriaDao CategoriaDao;

	@Override
	@Transactional(readOnly= true)
	public ResponseEntity<CategoriaResponseRest> search() {
		
		CategoriaResponseRest response = new CategoriaResponseRest();
		
		try {
			List<Categoria> categoria =(List<Categoria>) CategoriaDao.findAll();
			response.getCategoriaResponse().setCategoria(categoria);
			response.setMetadata("Respuesta Ok", "00", "Respuesta exitosa");
		}
		catch (Exception e){
			response.setMetadata("Respuesta nOk","-1","Error al consultar categorias");
			e.getStackTrace();
			return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional(readOnly= true)
	public ResponseEntity<CategoriaResponseRest> searchById(Long id) {
		
		CategoriaResponseRest response = new CategoriaResponseRest();
		List<Categoria> list = new ArrayList<>();
		
		try {
			Optional <Categoria> categoria = CategoriaDao.findById(id);
			if (categoria.isPresent()) {
				list.add(categoria.get());
				response.getCategoriaResponse().setCategoria(list);
				response.setMetadata("Respuesta Ok", "00", "Categoria encontrada");
			}
			else {
				response.setMetadata("Respuesta nOk", "-1", "Categoria no encontrada");
				return new ResponseEntity<CategoriaResponseRest>(response,HttpStatus.NOT_FOUND);
			}			
		}
		catch (Exception e) {
			response.setMetadata("Respuesta nOk", "-1", "Error al consultar por id de la categoria");
			e.getStackTrace();
			return new ResponseEntity<CategoriaResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<CategoriaResponseRest>(response,HttpStatus.OK);
		
	}

	@Override
	@Transactional
	public ResponseEntity<CategoriaResponseRest> save(Categoria categoria) {
		
		CategoriaResponseRest response = new CategoriaResponseRest();
		List<Categoria> list = new ArrayList<>();
		
		try {
			Categoria categoriaSaved = CategoriaDao.save(categoria);
			if (categoriaSaved != null){
				list.add(categoriaSaved);
				response.getCategoriaResponse().setCategoria(list);
				response.setMetadata("Respuesta Ok", "00", "Categoria guardada con éxito");
			}
			else {
				response.setMetadata("Respuesta nOk", "-1", "Categoria no  guardado");
				return new ResponseEntity<CategoriaResponseRest>(response,HttpStatus.BAD_REQUEST);
			}
		}
		catch (Exception e) {
			response.setMetadata("Respuesta nOk", "-1", "Error al grabar el categoria");
			e.getStackTrace();
			return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CategoriaResponseRest> update(Categoria categoria, Long id) {
		
		CategoriaResponseRest response = new CategoriaResponseRest();
		List<Categoria> list = new ArrayList<>();
		
		try {
			Optional <Categoria> categoriaSearch = CategoriaDao.findById(id);
			if (categoriaSearch.isPresent()){
				
				categoriaSearch.get().setNombre(categoria.getNombre());
				categoriaSearch.get().setDescripcion(categoria.getDescripcion());
				
				Categoria categoriaToupdate = CategoriaDao.save(categoriaSearch.get());
				
				if (categoriaToupdate != null){
					list.add(categoriaToupdate);
					response.getCategoriaResponse().setCategoria(list);
					response.setMetadata("Respuesta Ok", "00", "Autor actualizado");
				}
				else {
					response.setMetadata("Respuesta nok", "-1", "Actor no actualizado");
					return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.BAD_REQUEST);
				}
			}
			else {
				response.setMetadata("Respuesta nok", "-1", "Actor no encontrado");
				return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		}
		catch (Exception e) {
			response.setMetadata("Respuesta nok", "-1", "Error al actualizar el autor");
			e.getStackTrace();
			return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CategoriaResponseRest> deleteById(Long id) {
		
		CategoriaResponseRest response = new CategoriaResponseRest();
		
		try {
			CategoriaDao.deleteById(id);
			response.setMetadata("Respuesta ok", "00", "Registro eliminado con éxito");
		}
		catch(Exception e){
			response.setMetadata("Respuesta nok", "-1", "Error al eliminar la categoria");
			e.getStackTrace();
			return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<CategoriaResponseRest>(response, HttpStatus.OK);
		
	}

}
