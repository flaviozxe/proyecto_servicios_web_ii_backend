package com.novavita.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novavita.repository.UsuarioRolRepository;

@Service
public class UsuarioRolServiceImpl implements UsuarioRolService{
	@Autowired
	UsuarioRolRepository usuarioRolRpository;
	
	@Override
	public void cambiarRolUsuario(Long idUsuario, Long idRol) {
		usuarioRolRpository.usp_actualizar_rol_usuario(idUsuario, idRol);
	}

}
