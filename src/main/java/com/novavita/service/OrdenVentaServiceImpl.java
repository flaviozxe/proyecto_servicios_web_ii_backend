package com.novavita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novavita.model.OrdenVenta;
import com.novavita.repository.IOrdenVentaRepository;

@Service
public class OrdenVentaServiceImpl implements OrdenVentaService{
	
	@Autowired 
	IOrdenVentaRepository repoOrdenVenta;
	
	@Override
	public void insertarOrdenVenta(Long idUsuario, int idTarjeta, int idDireccion, String fecOrdenVenta,
			double impOrdenVenta, double desOrdenVenta, double envio, double total) {
		repoOrdenVenta.uspInsertarOrdenVenta(idUsuario, idTarjeta, idDireccion, fecOrdenVenta, impOrdenVenta, desOrdenVenta, envio, total);
	}

	@Override
	public void insertarDetalleOrdenVenta(int idProducto, int cantProducto, double precioProducto, double subTotal) {
		repoOrdenVenta.uspInsertarDetalleOrdenVenta(idProducto, cantProducto, precioProducto, subTotal);
	}

	@Override
	public List<OrdenVenta> listarPorIdUsuario(Long idUsuario) {
		return repoOrdenVenta.findAllByIdUsuario(idUsuario);
	}

}
