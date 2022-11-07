package com.novavita.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.novavita.model.Rol;
import com.novavita.model.Usuario;
import com.novavita.model.UsuarioRol;
import com.novavita.service.RolService;
import com.novavita.service.UsuarioRolService;
import com.novavita.service.UsuarioService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private RolService rolService;
    
    @Autowired
    private UsuarioRolService usuarioRolService;

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
        
		System.out.println("");
		System.out.println("Se ah registrado el usuario");
        
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
         
        //obtener rol
        Rol rol = rolService.buscarRolNombre(nomRol);
       
        //cambiar rol a usuario
        usuarioRolService.cambiarRolUsuario(reg.getId(), rol.getRolId());
        

		System.out.println("");
		System.out.println("Se ah actualizado el usuario");

        return usuarioService.actualizarUsuario(reg,usuarioRoles);
    }

    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
		System.out.println("");
		System.out.println("Se ah obtenido el usuario");
    	
        return usuarioService.obtenerUsuario(username);
    }

    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
		System.out.println("");
		System.out.println("Se ah eliminado el usuario");
		
        usuarioService.eliminarUsuario(usuarioId);
    }
    
    @GetMapping("/lista")
	@ResponseBody
	public ResponseEntity<List<Usuario>> listaUsuario(
			@RequestParam(name = "paramEnable", required = false, defaultValue = "") boolean enabled){
		System.out.println("");
		System.out.println("Se ah listado los usuarios");
	
		List<Usuario> lista = usuarioService.listaUsuarioPorEnabled(enabled);
		return ResponseEntity.ok(lista);
	}
    
    @GetMapping("/lista/rol")
	@ResponseBody
	public ResponseEntity<List<Rol>> listaRol(){
    	
		System.out.println("");
		System.out.println("Se ah listado los roles");
    	
		List<Rol> lista = rolService.listarRol();
		return ResponseEntity.ok(lista);
	}
    

    @DeleteMapping("/desactivar/{usuarioId}")
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> eliminaUsuario(@PathVariable("usuarioId") Long usuarioId){
		HashMap<String, Object> salida = new HashMap<String, Object>();
		try {
	        usuarioService.eliminarUsuarioPorId(usuarioId);
	        
			System.out.println("");
			System.out.println("Se ah eliminado el usuario");
			
			salida.put("message", "eliminacion exitosa");

		}
		catch(Exception ex) {
			salida.put("message", "el objeto que envio es nulo");
			ex.printStackTrace();
		}
		
		return ResponseEntity.ok(salida);

	}
    
}
