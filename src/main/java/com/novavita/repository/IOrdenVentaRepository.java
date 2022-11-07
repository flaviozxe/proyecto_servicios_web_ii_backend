package com.novavita.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.novavita.model.OrdenVenta;

@Repository
public interface IOrdenVentaRepository extends JpaRepository<OrdenVenta, Integer>{
	
	@Transactional
	@Modifying
	@Query(value = "{call usp_inertar_orden_venta(:id, :id_tarjeta, :id_direccion, :fec_orden_venta, :imp_orden_venta, :des_orden_venta, :envio, :total) }" , nativeQuery = true)
	void uspInsertarOrdenVenta(
			@Param("id")Long id_usuario,
			@Param("id_tarjeta") int id_tarjeta,
			@Param("id_direccion") int id_direccion,
			@Param("fec_orden_venta") String fec_orden_venta,
			@Param("imp_orden_venta") double  imp_orden_venta,
			@Param("des_orden_venta") double  des_orden_venta,
			@Param("envio") double  envio,
			@Param("total") double  total
	);
	
	@Transactional
	@Modifying
	@Query(value = "{call usp_insertar_detalle_orden_venta(:id_productoI, :cant_producto, :precio_producto, :sub_total) }" , nativeQuery = true)
	void uspInsertarDetalleOrdenVenta(
			@Param("id_productoI")int id_productoI,
			@Param("cant_producto") int cant_producto,
			@Param("precio_producto") double precio_producto,
			@Param("sub_total") double sub_total
	);
	
	
	List<OrdenVenta> findAllByIdUsuario(Long idUsuario);
	
	
}
