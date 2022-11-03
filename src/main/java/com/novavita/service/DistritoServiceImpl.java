package com.novavita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novavita.model.Distrito;
import com.novavita.repository.IDistritoRepository;

@Service
public class DistritoServiceImpl implements DistritoService{
	
	@Autowired
	IDistritoRepository repoDistrito;
	
	@Override
	public List<Distrito> listaDistritos() {
		return repoDistrito.findAll();
	}
	
	
	
}
