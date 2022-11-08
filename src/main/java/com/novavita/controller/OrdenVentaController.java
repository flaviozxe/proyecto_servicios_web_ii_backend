package com.novavita.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.novavita.model.OrdenVenta;
import com.novavita.model.Usuario;
import com.novavita.service.OrdenVentaService;
import com.novavita.service.UserDetailsServiceImpl;

@RestController
@RequestMapping("/ordenVenta")
@CrossOrigin("*")

public class OrdenVentaController {
	
	@Autowired
	OrdenVentaService serviceOrdenVenta;
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@PostMapping("/insetarOrdenVenta")
	public void insertarOrdenVenta( Principal principal,
			@RequestParam(name = "paramIdTarjeta", required = false, defaultValue = "") int idTarjeta,
			@RequestParam(name = "paramIdDireccion", required = false, defaultValue = "") int idDireccion,
			@RequestParam(name = "paramImpOrdenVenta", required = false, defaultValue = "") double impOrdenVenta,
			@RequestParam(name = "paramDesOrdenVenta", required = false, defaultValue = "") double desOrdenVenta,
			@RequestParam(name = "paramEnvio", required = false, defaultValue = "") double envio,
			@RequestParam(name = "paramTotal", required = false, defaultValue = "") double total ) {
		String fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
    	Usuario usuario = (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());
		serviceOrdenVenta.insertarOrdenVenta(usuario.getId(), idTarjeta, idDireccion, fechaActual, impOrdenVenta, desOrdenVenta, envio, total);
	}
	
	@PostMapping("/insertarDetalleOrdenVenta")
	public void insertarDetalleOrdenVenta(    		
			@RequestParam(name = "paramIdProducto", required = false, defaultValue = "") int idProducto,
			@RequestParam(name = "paramCantProducto", required = false, defaultValue = "") int cantProducto,
			@RequestParam(name = "paramPrecioProducto", required = false, defaultValue = "") double precioProducto,
			@RequestParam(name = "paramSubTotal", required = false, defaultValue = "") double subTotal) {
		serviceOrdenVenta.insertarDetalleOrdenVenta(idProducto, cantProducto, precioProducto, subTotal);
	}
	
	@GetMapping("/lista")
	@ResponseBody
	public ResponseEntity<List<OrdenVenta>> listaOrdenVentaIdUsuario(Principal principal){	
    	Usuario usuario = (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());
    	
		List<OrdenVenta> lista = serviceOrdenVenta.listarPorIdUsuario(usuario.getId());
		return ResponseEntity.ok(lista);
	}
	
}
