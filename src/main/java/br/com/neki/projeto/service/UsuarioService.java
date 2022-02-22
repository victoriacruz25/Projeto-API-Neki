package br.com.neki.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.neki.projeto.entity.Usuario;
import br.com.neki.projeto.entity.DTO.UsuarioDTO;
import br.com.neki.projeto.repository.UsuarioRepository;

public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Usuario save(UsuarioDTO dto) {
		Usuario usuario = new Usuario();
		usuario.setLogin(dto.getLogin());
		usuario.setSenha(dto.getSenha());
		usuario.setUltimoLoginData(dto.getUltimoLoginData());
		return usuarioRepository.save(usuario);
	}
	
	public Usuario findById(Integer id) {
		Optional<Usuario> entity = usuarioRepository.findById(id);
			if (entity.isPresent()) {
				return entity.get();
			}
			
			throw new RuntimeException();
	}
	
	public Usuario update(Usuario usuario, UsuarioDTO dto) {
		usuario.setLogin(dto.getLogin());
		usuario.setSenha(dto.getSenha());
		usuario.setUltimoLoginData(dto.getUltimoLoginData());
		return usuarioRepository.save(usuario);
	
	}
	
	public void delete(Integer id) {
		usuarioRepository.deleteById(id);
	}
	

}
