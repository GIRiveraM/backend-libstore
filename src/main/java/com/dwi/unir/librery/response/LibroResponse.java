package com.dwi.unir.librery.response;

import java.util.List;

import com.dwi.unir.librery.model.Libro;

import lombok.Data;

@Data
public class LibroResponse {
	private List<Libro> libro;
}
