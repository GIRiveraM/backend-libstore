package com.unir.librery.response;

import java.util.List;

import com.unir.librery.model.Editorial;

import lombok.Data;

@Data
public class EditorialResponse {
	private List<Editorial> editorial;
}
