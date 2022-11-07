package com.novavita.service;

import java.util.List;

import com.novavita.model.DetalleOrdenVenta;

public interface DetalleOrdenVentaService {
	
	List<DetalleOrdenVenta> listarPorNumeroDeOrdenVenta(int numOrdenVenta);


}
