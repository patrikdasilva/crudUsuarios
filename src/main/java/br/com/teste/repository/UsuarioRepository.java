package br.com.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
}
