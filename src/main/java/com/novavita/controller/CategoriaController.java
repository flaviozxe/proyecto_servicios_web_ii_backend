package com.novavita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.novavita.model.Categoria;
import com.novavita.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")

public class CategoriaController {
	
	@Autowired
	private CategoriaService serviceCategoria;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Categoria>> listaCategoria() {
		
		return ResponseEntity.ok(serviceCategoria.listaCategoria());
		
	}
	

}
