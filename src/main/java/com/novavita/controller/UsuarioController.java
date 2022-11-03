package com.novavita.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.novavita.model.Rol;
import com.novavita.model.Usuario;
import com.novavita.model.UsuarioRol;
import com.novavita.service.RolService;
import com.novavita.service.UsuarioService;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private RolService rolService;

    @PostMapping("/registrar")
    public Usuario guardarUsuario(
    		@RequestParam(name = "paramDni", required = false, defaultValue = "") String dni,
			@RequestParam(name = "paramNombre", required = false, defaultValue = "") String nombre,
			@RequestParam(name = "paramApellido", required = false, defaultValue = "") String apellido,
			@RequestParam(name = "paramTelefono", required = false, defaultValue = "") String telefono,
			@RequestParam(name = "paramEmail", required = false, defaultValue = "") String email,
			@RequestParam(name = "paramUsername", required = false, defaultValue = "") String username,
			@RequestParam(name = "paramPassword", required = false, defaultValue = "") String password,
			@RequestParam(name = "paramRol", required = false, defaultValue = "") Long rol) throws Exception{
        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Usuario reg = new Usuario();
        reg.setDni(dni);
        reg.setNombre(nombre);
        reg.setApellido(apellido);
        reg.setTelefono(telefono);
        reg.setEmail(email);
        reg.setUsername(username);
        reg.setPassword(password);
        
        Rol rolU = rolService.buscarRolporId(rol);
        

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(reg);
        usuarioRol.setRol(rolU);

        usuarioRoles.add(usuarioRol);
        return usuarioService.guardarUsuario(reg,usuarioRoles);
    }
    
    
    @PutMapping("/actualizar")
    public Usuario actualizarUsuario(
    		@RequestParam(name = "paramId", required = false, defaultValue = "") Long id,
    		@RequestParam(name = "paramDni", required = false, defaultValue = "") String dni,
			@RequestParam(name = "paramNombre", required = false, defaultValue = "") String nombre,
			@RequestParam(name = "paramApellido", required = false, defaultValue = "") String apellido,
			@RequestParam(name = "paramTelefono", required = false, defaultValue = "") String telefono,
			@RequestParam(name = "paramEmail", required = false, defaultValue = "") String email,
			@RequestParam(name = "paramUsername", required = false, defaultValue = "") String username,
			@RequestParam(name = "paramPassword", required = false, defaultValue = "") String password,
			@RequestParam(name = "paramRol", required = false, defaultValue = "") String nomRol) throws Exception{
        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Usuario reg = usuarioService.obtenerUsuario(username);
        reg.setId(id);
        reg.setDni(dni);
        reg.setNombre(nombre);
        reg.setApellido(apellido);
        reg.setTelefono(telefono);
        reg.setEmail(email);
        reg.setUsername(username);
        reg.setPassword(password);
        
        Rol rolU = rolService.buscarRolNombre(nomRol);
        

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(reg);
        usuarioRol.setRol(rolU);

        usuarioRoles.add(usuarioRol);
        return usuarioService.actualizarUsuario(reg,usuarioRoles);
    }

    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
        return usuarioService.obtenerUsuario(username);
    }

    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        usuarioService.eliminarUsuario(usuarioId);
    }

}
