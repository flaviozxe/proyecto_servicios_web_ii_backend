package com.novavita.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.novavita.model.Producto;
import com.novavita.service.ProductoService;


@RestController
@RequestMapping("/producto")
@CrossOrigin("*")
public class ProductoController {
	@Autowired
	ProductoService serviceProducto;
	
	@GetMapping("/lista/mejorcalidad")
	@ResponseBody
	public ResponseEntity<List<Producto>> listaProductoMejorCalidad(){
		List<Producto> lista = serviceProducto.listarProductoMejorCalidad();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/buscar/id/{paramId}")
	@ResponseBody
	public ResponseEntity<Producto> buscarProducto(@PathVariable("paramId") int idProducto){
		Optional<Producto> optProducto = serviceProducto.buscarProductoPorId(idProducto);
		if(optProducto.isPresent()) {
			return ResponseEntity.ok(optProducto.get());
		}
		else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/lista/stock")
	@ResponseBody
	public ResponseEntity<List<Producto>> listarProductoConStock(){
		List<Producto> lista = serviceProducto.listarProductoConStock();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/listar/categoria/marca")
	@ResponseBody
	public ResponseEntity<List<Producto>> listarProductoPorCategoriaYMarca(
			@RequestParam(name = "paramIdCategoria", required = false, defaultValue = "") int id_categoria,
			@RequestParam(name = "paramMarcaProducto", required = false, defaultValue = "") String marca_producto){
		List<Producto> lista = serviceProducto.listarProductoPorCategoriaYMarca(id_categoria, marca_producto);
		return ResponseEntity.ok(lista);
	}
	
}
