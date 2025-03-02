package com.dwi.unir.librery.response;

import java.util.List;

import com.dwi.unir.librery.model.Categoria;

import lombok.Data;

@Data
public class CategoriaResponse {
	private List<Categoria> categoria;
}
