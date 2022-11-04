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

import com.novavita.model.Tarjeta;
import com.novavita.model.Usuario;
import com.novavita.service.TarjetaService;
import com.novavita.service.UserDetailsServiceImpl;

@RestController
@RequestMapping("/tarjeta")
@CrossOrigin("*")

public class TarjetaController {
	@Autowired
	TarjetaService tarjetaService;

	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@GetMapping("/lista")
	@ResponseBody
	public ResponseEntity<List<Tarjeta>> listaDireccionIdUsuario(Principal principal,
			@RequestParam(name = "paramEstado", required = false, defaultValue = "") int estado){
    	Usuario usuario = (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());
		List<Tarjeta> lista = tarjetaService.listaTarjetaPorUsuarioEstado(usuario.getId(), estado);
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/obtener")
	@ResponseBody
	public ResponseEntity<Tarjeta> obtenerTarjeta(
			@RequestParam(name = "paramTarjeta", required = false, defaultValue = "") int idTarjeta){
		Tarjeta tarjeta = tarjetaService.buscarTarjetaId(idTarjeta);
		return ResponseEntity.ok(tarjeta);
	}
	
	
	@PostMapping("/registrar")
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> registrarTarjeta(Principal principal, @RequestBody Tarjeta bean){
		HashMap<String, Object> salida = new HashMap<String, Object>();
    	Usuario usuario = (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());
	    Tarjeta item = tarjetaService.buscarTarjetaPorIdUsuarioNumeroTarjetaEstado(usuario.getId(), bean.getNumeroTarjeta(), 1);
		Boolean respuesta = false;
			
		if(item != null ) {
			respuesta = false;
			
		}
		else {
			respuesta = true;
		}
		
		try {
			if(respuesta == true) {
				bean.setEstado(1);
				bean.setIdUsuario(usuario.getId());
				
				Tarjeta objetoSalida = tarjetaService.registrarTarjeta(bean);	
				if(objetoSalida != null) {
					salida.put("message", "registro exitoso");
				}
				else {
					salida.put("error", "error en el registro");
				}
			}
			else {
				salida.put("error", "Verifique si ya tiene registrado este numero de tarjeta");
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return ResponseEntity.ok(salida);

	}
	
	@PutMapping("/actualizar")
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> actualizarTarjeta(@RequestBody Tarjeta bean){
		HashMap<String, Object> salida = new HashMap<String, Object>();

		try {
			
			if(bean != null) {	
				List<Tarjeta> listaBusca = tarjetaService.listaTarjetaPorNumeroTDiferenteDelMismoID(bean.getNumeroTarjeta(), bean.getIdTarjeta());
								
				if(listaBusca.size() == 0) {
					Tarjeta objetoSalida = tarjetaService.actualizarTarjeta(bean);	
					if(objetoSalida != null) {
						salida.put("message", "actualizacion exitosa");
					}
					else {
						salida.put("error", "error en el actualizacion");
					}
				}
				else {
					salida.put("error", "la tarjeta que ha ingresado ya esta en uso");
				}
				
			}
			else {
				salida.put("error", "el objeto que envio es nulo");
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return ResponseEntity.ok(salida);

	}
	
	@DeleteMapping("/eliminar")
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> eliminaTarjeta(
			@RequestParam(name = "paramTarjeta", required = false, defaultValue = "") int idTarjeta){
		HashMap<String, Object> salida = new HashMap<String, Object>();
		
		try {
			tarjetaService.eliminarTarjeta(idTarjeta);
			salida.put("message", "eliminacion exitosa");

		}
		catch(Exception ex) {
			salida.put("error", "el objeto que envio es nulo");
			ex.printStackTrace();
		}
		
		return ResponseEntity.ok(salida);

	}
}
