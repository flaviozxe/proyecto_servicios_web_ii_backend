package com.novavita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novavita.model.Tarjeta;
import com.novavita.repository.ITarjetaRepositoy;

@Service
public class TarjetaServiceImpl implements TarjetaService{
	
	@Autowired
	ITarjetaRepositoy repoTarjeta;
	
	@Override
	public List<Tarjeta> listaTarjetaPorUsuarioEstado(Long idUsuario, int estado) {
		return repoTarjeta.findAllByIdUsuarioAndEstado(idUsuario, estado);
	}

	@Override
	public Tarjeta buscarTarjetaPorIdUsuarioNumeroTarjetaEstado(Long idUsuario, String numeroTarjeta, int estado) {
		return repoTarjeta.findByIdUsuarioAndNumeroTarjetaAndEstado(idUsuario, numeroTarjeta, estado);
	}

	@Override
	public Tarjeta buscarTarjetaId(int idTarjeta) {
		return repoTarjeta.findByIdTarjeta(idTarjeta);
	}

	@Override
	public void eliminarTarjeta(int idTarjeta) {
		 repoTarjeta.usp_eliminar_tarjeta(idTarjeta);
	}

	@Override
	public Tarjeta registrarTarjeta(Tarjeta bean) {
		return repoTarjeta.save(bean);
	}

	@Override
	public Tarjeta actualizarTarjeta(Tarjeta bean) {
		return repoTarjeta.save(bean);
	}

	@Override
	public List<Tarjeta> listaTarjetaPorNumeroTDiferenteDelMismoID(String num_tarjeta, int id) {
		return repoTarjeta.listaTarjetaPorNumeroTDiferenteDelMismoID(num_tarjeta, id);
	}



}
