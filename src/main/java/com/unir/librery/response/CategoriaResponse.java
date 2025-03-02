package com.unir.librery.response;

import java.util.List;

import com.unir.librery.model.Categoria;

import lombok.Data;

@Data
public class CategoriaResponse {
	private List<Categoria> categoria;
}
