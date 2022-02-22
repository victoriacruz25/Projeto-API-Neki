package br.com.neki.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.neki.projeto.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Usuario findByLoginAndSenha(String login, String senha);

}
