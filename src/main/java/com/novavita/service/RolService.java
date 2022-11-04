package com.novavita.service;

import java.util.List;

import com.novavita.model.Rol;

public interface RolService {
	
	public Rol buscarRolporId(Long id);
	
	public Rol buscarRolNombre(String rolNombre);
	
	public List<Rol> listarRol();
	
}
