package br.com.neki.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.neki.projeto.entity.HabilidadeUsuario;

public interface HabilidadeUsuarioRepository extends JpaRepository<HabilidadeUsuario, Integer> {
		
	List<HabilidadeUsuario> findByUsuario(Integer id);
}
