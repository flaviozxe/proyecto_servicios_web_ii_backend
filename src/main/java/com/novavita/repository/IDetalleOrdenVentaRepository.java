package com.novavita.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.novavita.model.DetalleOrdenVenta;

@Repository
public interface IDetalleOrdenVentaRepository extends JpaRepository<DetalleOrdenVenta, Integer>{
	
	List<DetalleOrdenVenta> findAllByNumOrdenVenta(int numOrdenVenta);
	
	
}
