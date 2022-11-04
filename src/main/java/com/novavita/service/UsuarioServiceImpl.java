package com.novavita.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.novavita.model.Usuario;
import com.novavita.model.UsuarioRol;
import com.novavita.repository.RolRepository;
import com.novavita.repository.UsuarioRepository;

import java.util.List;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
	private BCryptPasswordEncoder passwordEncoder;
    
    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioLocal != null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta presente");
        }
        else{
            for(UsuarioRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }
    
    @Override
	public Usuario actualizarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
    	Usuario usuarioLocal = new Usuario();
        
 
        usuarioLocal = usuarioRepository.save(usuario);
        return usuarioLocal;
	}

    
    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsernameAndEnabled(username, true);
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

	@Override
	public List<Usuario> listaUsuarioPorEnabled(boolean enabled) {
		return usuarioRepository.findAllByEnabled(enabled);
	}

	@Override
	public void eliminarUsuarioPorId(Long id) {
		 usuarioRepository.usp_eliminar_usuario(id);
	}

	
}