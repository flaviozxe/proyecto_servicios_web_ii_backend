package com.novavita.service;

import com.novavita.model.Rol;

public interface RolService {
	
	public Rol buscarRolporId(Long id);
	
	public Rol buscarRolNombre(String rolNombre);
	
}
