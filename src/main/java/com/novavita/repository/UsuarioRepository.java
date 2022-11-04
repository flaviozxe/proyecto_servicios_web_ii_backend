package com.novavita.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.novavita.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public Usuario findByUsername(String username);
    
	Usuario findByUsernameAndEnabled(String username, boolean enabled);
	List<Usuario> findAllByEnabled (boolean enabled);
	
	@Query(value = "{call usp_listado_usuario_nombre(:nombreI)}", nativeQuery = true)
	List<Usuario> usp_listado_usuario_nombre(
			@Param("nombreI")String nombreI
			);
	
	@Transactional
	@Modifying
	@Query(value = "{call usp_eliminar_usuario(:id)}", nativeQuery = true)
	void usp_eliminar_usuario(
			@Param("id")Long id
			);
	
	

}
