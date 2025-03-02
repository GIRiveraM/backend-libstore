package com.unir.librery.response;

import java.util.List;

import com.unir.librery.model.Libro;

import lombok.Data;

@Data
public class LibroResponse {
	private List<Libro> libro;
}
