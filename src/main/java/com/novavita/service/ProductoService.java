package com.novavita.service;

import java.util.List;
import java.util.Optional;

import com.novavita.model.Producto;

public interface ProductoService {
	
	Producto buscarPorCodigoYEstado(String codigo, int estado);
	Optional<Producto> buscarProductoPorId(int idProducto);
	List<Producto> listarProductoPorCategoriaYMarca(int id_categoria, String marca_producto);
	List<Producto> listarProductoConStock();
	List<Producto> listarProducto();
	void eliminarProducto(int id_productoI);
	List<Producto> listarProductoMejorCalidad();


}
