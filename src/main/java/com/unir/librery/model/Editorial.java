package com.unir.librery.model;

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
@Table(name="editoriales")
public class Editorial implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8503815325488924904L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 255)
	private String nombre;
	
	@Column(length = 100)
	private String pais;
	
	@Column(length = 255)
	private String sitio_web;
}
