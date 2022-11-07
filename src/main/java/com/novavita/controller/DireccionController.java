package com.novavita.controller;



import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.novavita.model.Direccion;
import com.novavita.model.Distrito;
import com.novavita.model.Usuario;
import com.novavita.service.DireccionService;
import com.novavita.service.DistritoService;
import com.novavita.service.UserDetailsServiceImpl;

@RestController
@RequestMapping("/direccion")
@CrossOrigin("*")

public class DireccionController {
	
	@Autowired
	DireccionService direccionService;
	@Autowired
	DistritoService distritoService;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@GetMapping("/lista")
	@ResponseBody
	public ResponseEntity<List<Direccion>> listaDireccionIdUsuario(Principal principal,
			@RequestParam(name = "paramEstado", required = false, defaultValue = "") int estado){	
    	Usuario usuario = (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());
    	
		System.out.println("");
		System.out.println("Se ah listado las direcciones");
		List<Direccion> lista = direccionService.listaDireccionPorUsuario(usuario.getId(), estado);
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/obtener")
	@ResponseBody
	public ResponseEntity<Direccion> obtenerDireccion(
			@RequestParam(name = "paramDireccion", required = false, defaultValue = "") int idDireccion){
		
		System.out.println("");
		System.out.println("Se ah obtener las direcciones");
		Direccion direccion = direccionService.obtenerDireccionPorId(idDireccion);
		return ResponseEntity.ok(direccion);
	}
	
	@GetMapping("/lista/distrito")
	@ResponseBody
	public ResponseEntity<List<Distrito>> listaDistrito(){
		System.out.println("");
		System.out.println("Se ah listado los distritos");
		List<Distrito> lista = distritoService.listaDistritos();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registrar")
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> registrarDireccion(Principal principal, @RequestBody Direccion bean){
		HashMap<String, Object> salida = new HashMap<String, Object>();
    	Usuario usuario = (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());

		try {
			if(bean != null) {
				bean.setEstado(1);
				bean.setIdUsuario(usuario.getId());
				
				Direccion objetoSalida = direccionService.registrarDireccion(bean);	
				if(objetoSalida != null) {
					System.out.println("");
					System.out.println("Se ah registrado la direccion");
					salida.put("message", "registro exitoso");
				}
				else {
					salida.put("message", "error en el registro");
				}
			}
			else {
				salida.put("message", "el objeto que envio es nulo");
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return ResponseEntity.ok(salida);

	}
	
	@PutMapping("/actualizar")
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> actualizarDireccion(@RequestBody Direccion bean){
		HashMap<String, Object> salida = new HashMap<String, Object>();
		try {
			if(bean != null) {			
				Direccion objetoSalida = direccionService.actualizcionDireccion(bean);	
				if(objetoSalida != null) {
					System.out.println("");
					System.out.println("Se ah actualizado la direccion");
					salida.put("message", "actualizacion exitosa");
				}
				else {
					salida.put("message", "error en el actualizacion");
				}
			}
			else {
				salida.put("message", "el objeto que envio es nulo");
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return ResponseEntity.ok(salida);

	}
	
	@DeleteMapping("/eliminar")
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> eliminaDireccion(
			@RequestParam(name = "paramDireccion", required = false, defaultValue = "") int idDireccion){
		HashMap<String, Object> salida = new HashMap<String, Object>();
		try {
			direccionService.eliminarDireccion(idDireccion);
			System.out.println("");
			System.out.println("Se ah elimado la direccion");
			salida.put("message", "eliminacion exitosa");

		}
		catch(Exception ex) {
			salida.put("message", "el objeto que envio es nulo");
			ex.printStackTrace();
		}
		
		return ResponseEntity.ok(salida);

	}
}
