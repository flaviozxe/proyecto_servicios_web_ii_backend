package com.novavita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.novavita.model.DetalleOrdenVenta;
import com.novavita.service.DetalleOrdenVentaService;

@RestController
@RequestMapping("/detalleOrdenVenta")
@CrossOrigin("*")

public class DetalleOrdenVentaController {
	
	@Autowired
	DetalleOrdenVentaService serviceDetalleOrdenVenta;
	
	@GetMapping("/lista")
	@ResponseBody
	public ResponseEntity<List<DetalleOrdenVenta>> listaDetalleOrdenVentaPorNumeroOrdenVenta(
			@RequestParam(name = "paramIdOrdenVenta", required = false, defaultValue = "") int idOrdenVenta){	
    	
		List<DetalleOrdenVenta> lista = serviceDetalleOrdenVenta.listarPorNumeroDeOrdenVenta(idOrdenVenta);
		return ResponseEntity.ok(lista);
	}
	
}
