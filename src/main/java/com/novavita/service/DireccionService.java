package com.novavita.service;

import java.util.List;

import com.novavita.model.Direccion;

public interface DireccionService {
	
	public List<Direccion> listaDireccionPorUsuario(Long idUsuario, int estado);
	
	public Direccion obtenerDireccionPorId(int idDireccion);
	
	public Direccion registrarDireccion(Direccion bean);
	
}
