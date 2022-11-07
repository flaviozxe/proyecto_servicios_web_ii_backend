package com.novavita.service;

import java.util.List;

import com.novavita.model.OrdenVenta;


public interface OrdenVentaService {
	
	public void insertarOrdenVenta(
			Long idUsuario,
			int idTarjeta,
			int idDireccion,
			String fecOrdenVenta,
			double  impOrdenVenta,
			double  desOrdenVenta,
			double  envio,
			double  total
	);
	
	public void insertarDetalleOrdenVenta(
			int idProducto,
			int cantProducto,
			double precioProducto,
			double subTotal
	);
	
	
	List<OrdenVenta> listarPorIdUsuario(Long idUsuario);
}
