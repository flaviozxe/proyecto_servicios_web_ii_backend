package com.novavita.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tb_detalle_orden_venta")


public class DetalleOrdenVenta {
	
	@Id
	@Column(name = "numero_detalle_orden_venta")
	private int detalleNumOrdenVenta;
	@Column(name = "num_orden_venta")
	private int numOrdenVenta;
	@Column(name = "id_producto")
	private int idProducto;
	@Column(name = "cant_producto")
	private int cantidad;
	@Column(name = "precio_producto")
	private double precio;
	@Column(name = "sub_total")
	private double subtotal;
	
	@ManyToOne
	@JoinColumn(name = "id_producto", insertable = false, updatable = false)
	private Producto producto;

	public int getDetalleNumOrdenVenta() {
		return detalleNumOrdenVenta;
	}

	public void setDetalleNumOrdenVenta(int detalleNumOrdenVenta) {
		this.detalleNumOrdenVenta = detalleNumOrdenVenta;
	}

	public int getNumOrdenVenta() {
		return numOrdenVenta;
	}

	public void setNumOrdenVenta(int numOrdenVenta) {
		this.numOrdenVenta = numOrdenVenta;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
}
