package com.dwi.unir.librery.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="libros_autores")
public class LibroAutor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2963344878809934696L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Long id_libro;
	
	@Column(nullable = false)
	private Long id_autor; 

}
