package com.novavita.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.novavita.model.Tarjeta;

public interface ITarjetaRepositoy extends JpaRepository<Tarjeta, Integer> {
		
	List<Tarjeta> findAllByIdUsuarioAndEstado(Long idUsuario, int estado);
	Tarjeta findByIdUsuarioAndNumeroTarjetaAndEstado(Long idUsuario, String numeroTarjeta, int estado);
	Tarjeta findByIdTarjeta(int idTarjeta);
	
	@Transactional
	@Modifying
	@Query(value = "{call usp_eliminar_tarjeta(:id_tarjetaI)}", nativeQuery = true)
	void usp_eliminar_tarjeta(
			@Param("id_tarjetaI")int id_tarjetaI
			);
	
}
