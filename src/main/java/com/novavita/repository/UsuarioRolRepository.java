package com.novavita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.novavita.model.UsuarioRol;

@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Long>{
	
	@Transactional
	@Modifying
	@Query(value = "{call usp_actualizar_rol_usuario(:id_usuarioV, :id_rolV)}", nativeQuery = true)
	void usp_actualizar_rol_usuario(
			@Param("id_usuarioV")Long idUsuario,
			@Param("id_rolV")Long idRol
			);
}
