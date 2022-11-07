package com.novavita.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_orden_venta")

public class OrdenVenta {
	@Id
	@Column(name = "num_orden_venta")
	private int numeroOrdenVenta;
	
	@Column(name = "id")
	private Long idUsuario;
	
	@Column(name = "id_tarjeta")
	private int idTarjeta;
	
	@Column(name = "id_direccion")
	private int idDireccion;
	
	@Column(name = "fec_orden_venta")
	private String fechaOrdenVenta;
	
	@Column(name = "imp_orden_venta")
	private double importeTotal;
	
	@Column(name = "desc_orden_venta")
	private double descuento;
	
	@Column(name = "envio")
	private double envio;
	
	@Column(name = "total_orden_venta")
	private double total;
	
	@ManyToOne
	@JoinColumn(name = "id_direccion", insertable = false, updatable = false)
	private Direccion direccion;
	
	@ManyToOne
	@JoinColumn(name = "id_tarjeta", insertable = false, updatable = false)
	private Tarjeta tarjeta;

	public int getNumeroOrdenVenta() {
		return numeroOrdenVenta;
	}

	public void setNumeroOrdenVenta(int numeroOrdenVenta) {
		this.numeroOrdenVenta = numeroOrdenVenta;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getFechaOrdenVenta() {
		return fechaOrdenVenta;
	}

	public void setFechaOrdenVenta(String fechaOrdenVenta) {
		this.fechaOrdenVenta = fechaOrdenVenta;
	}

	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public double getEnvio() {
		return envio;
	}

	public void setEnvio(double envio) {
		this.envio = envio;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	
}
