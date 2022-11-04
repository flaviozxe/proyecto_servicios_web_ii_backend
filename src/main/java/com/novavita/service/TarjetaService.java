package com.novavita.service;

import java.util.List;


import com.novavita.model.Tarjeta;

public interface TarjetaService {
	
	List<Tarjeta> listaTarjetaPorUsuarioEstado(Long idUsuario, int estado);
	Tarjeta buscarTarjetaPorIdUsuarioNumeroTarjetaEstado(Long idUsuario, String numeroTarjeta, int estado);
	Tarjeta buscarTarjetaId(int idTarjeta);
	Tarjeta registrarTarjeta(Tarjeta bean);
	Tarjeta actualizarTarjeta(Tarjeta bean);
	void eliminarTarjeta(int idTarjeta);
	List<Tarjeta> listaTarjetaPorNumeroTDiferenteDelMismoID(String num_tarjeta, int id);

	
}
