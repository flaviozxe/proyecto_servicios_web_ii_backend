package com.novavita.controller;



import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.novavita.model.Direccion;
import com.novavita.model.Usuario;
import com.novavita.service.DireccionService;
import com.novavita.service.UserDetailsServiceImpl;

@RestController
@RequestMapping("/direccion")
@CrossOrigin("*")

public class DireccionController {
	
	@Autowired
	DireccionService direccionService;
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@GetMapping("/lista")
	@ResponseBody
	public ResponseEntity<List<Direccion>> listaDireccionIdUsuario(Principal principal,
			@RequestParam(name = "paramEstado", required = false, defaultValue = "") int estado){
    	Usuario usuario = (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());
		List<Direccion> lista = direccionService.listaDireccionPorUsuario(usuario.getId(), estado);
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registrar")
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> registrarDireccion(@RequestBody Direccion bean){
		HashMap<String, Object> salida = new HashMap<String, Object>();
		
		try {
			if(bean != null) {
				bean.setEstado(1);
				Direccion objetoSalida = direccionService.registrarDireccion(bean);	
				if(objetoSalida != null) {
					salida.put("mensaje", "registro exitoso");
				}
				else {
					salida.put("mensaje", "error en el registro");
				}
			}
			else {
				salida.put("mensaje", "el objeto que envio es nulo");
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return ResponseEntity.ok(salida);

	}
	
}
