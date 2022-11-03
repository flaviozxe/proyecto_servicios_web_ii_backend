package com.novavita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novavita.model.Categoria;
import com.novavita.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	private CategoriaRepository repoCategoria;
	
	@Override
	public List<Categoria> listaCategoria() {
		return repoCategoria.findAll();
	}

}
