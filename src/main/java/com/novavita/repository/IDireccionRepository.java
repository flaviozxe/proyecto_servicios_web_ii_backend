package com.novavita.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.novavita.model.Direccion;

public interface IDireccionRepository extends JpaRepository<Direccion, Integer> {
	
	List<Direccion> findAllByIdUsuarioAndEstado(Long idUsuario, int estado);
	Direccion findByIdDireccion(int idDireccion);

	@Transactional
	@Modifying
	@Query(value = "{call usp_eliminar_direccion(:id_direccionI)}", nativeQuery = true)
	void usp_eliminar_direccion(
			@Param("id_direccionI")int id_direccionI
			);
	
}
