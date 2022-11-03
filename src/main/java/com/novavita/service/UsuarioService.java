package com.novavita.service;

import java.util.Set;

import com.novavita.model.Usuario;
import com.novavita.model.UsuarioRol;

public interface UsuarioService {
	 public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;
	 
	 public Usuario actualizarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

	 
	    public Usuario obtenerUsuario(String username);

	    public void eliminarUsuario(Long usuarioId);
}
