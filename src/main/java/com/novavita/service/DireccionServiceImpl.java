package com.novavita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novavita.model.Direccion;
import com.novavita.repository.IDireccionRepository;

@Service
public class DireccionServiceImpl implements DireccionService{
	
	@Autowired
	IDireccionRepository repoDireccion;
	
	@Override
	public List<Direccion> listaDireccionPorUsuario(Long idUsuario, int estado) {
		return repoDireccion.findAllByIdUsuarioAndEstado(idUsuario, estado);
	}

	@Override
	public Direccion obtenerDireccionPorId(int idDireccion) {
		return repoDireccion.findByIdDireccion(idDireccion);
	}

	@Override
	public Direccion registrarDireccion(Direccion bean) {
		return repoDireccion.save(bean);
	}

	@Override
	public Direccion actualizcionDireccion(Direccion bean) {
		return repoDireccion.save(bean);
	}

	@Override
	public void eliminarDireccion(int idDireccion) {
		repoDireccion.usp_eliminar_direccion(idDireccion);
	}

}
