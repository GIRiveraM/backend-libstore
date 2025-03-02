package com.dwi.unir.librery.response;

import java.util.List;

import com.dwi.unir.librery.model.Editorial;

import lombok.Data;

@Data
public class EditorialResponse {
	private List<Editorial> editorial;
}
