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
@Table(name="autores")
public class Autor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4091195941797557780L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false, length = 255)
    private String nombre;

    @Column(nullable = false, length = 255)
    private String apellido;
    
    @Column(columnDefinition = "TEXT")
    private String biografia;
    
    @Column(length = 100)
    private String nacionalidad;

}
