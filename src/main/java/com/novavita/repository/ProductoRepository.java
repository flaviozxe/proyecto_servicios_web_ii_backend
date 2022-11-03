package com.novavita.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.novavita.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
	Producto findByCodigoAndEstado(String codigo, int estado);

	List<Producto> findAllByMarcaAndIdCategoria(String marca, int categoria);
	
	Optional<Producto> findByIdProducto(int idProducto);
	
	
	@Query(value = "{call usp_listado_producto_categoria_marca(:id_categoriaI, :marca_productoI)}", nativeQuery = true)
	List<Producto> usp_listado_producto_categoria_marca(
			@Param("id_categoriaI")int id_categoria,
			@Param("marca_productoI")String marca_producto
			);
	
	@Query(value = "{call usp_listado_producto()}", nativeQuery = true)
	List<Producto> usp_listado_producto();
	
	
	@Query(value = "{call usp_listado_productoManten()}", nativeQuery = true)
	List<Producto> usp_listado_productoManten();
	
	@Transactional
	@Modifying
	@Query(value = "{call usp_eliminar_producto(:id_productoI)}", nativeQuery = true)
	void usp_eliminar_producto(
			@Param("id_productoI")int id_productoI
			);
	
	@Query(value = "{call usp_listado_producto_mejor_calidad()}", nativeQuery = true)
	List<Producto> usp_listado_producto_mejor_calidad();
}
