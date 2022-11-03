package com.novavita.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novavita.model.Producto;
import com.novavita.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	@Autowired
	ProductoRepository repoProducto;
	
	@Override
	public Producto buscarPorCodigoYEstado(String codigo, int estado) {
		return repoProducto.findByCodigoAndEstado(codigo, estado);
	}

	@Override
	public Optional<Producto> buscarProductoPorId(int idProducto) {
		return repoProducto.findByIdProducto(idProducto);
	}

	@Override
	public List<Producto> listarProductoPorCategoriaYMarca(int id_categoria, String marca_producto) {
		return repoProducto.usp_listado_producto_categoria_marca(id_categoria, marca_producto);
	}

	@Override
	public List<Producto> listarProductoConStock() {
		return repoProducto.usp_listado_producto();
	}

	@Override
	public List<Producto> listarProducto() {
		return repoProducto.usp_listado_productoManten();
	}

	@Override
	public void eliminarProducto(int idProducto) {
		 repoProducto.usp_eliminar_producto(idProducto);
	}

	@Override
	public List<Producto> listarProductoMejorCalidad() {
		return repoProducto.usp_listado_producto_mejor_calidad();
	}
	
	
}
