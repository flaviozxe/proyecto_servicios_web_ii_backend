package com.novavita.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.novavita.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public Usuario findByUsername(String username);

}
