package com.dwi.unir.librery.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name="libros")
public class Libro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7819450651419069735L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 225)
	private String titulo;
	
	@Column(unique = true, nullable = false, length = 20)
    private String isbn;
	
    @Column(nullable = false)
    private Long id_autor;
	
	@Column(nullable = false)
    private Long id_editorial;
	
	@Column(nullable = false)
    private Long id_categoria;
	
	@Temporal(TemporalType.DATE)
    @Column
    private Date fecha_publicacion;
	
	@Column
    private int num_paginas;
	 
	@Column(length = 50)
    private String idioma;
	 
	@Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column
    private int stock;

    @Column(name = "portada_url", length = 500)
    private String portadaUrl;

}
