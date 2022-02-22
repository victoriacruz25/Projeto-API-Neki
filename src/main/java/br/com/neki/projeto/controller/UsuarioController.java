package br.com.neki.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.projeto.entity.Usuario;
import br.com.neki.projeto.entity.DTO.UsuarioDTO;
import br.com.neki.projeto.repository.UsuarioRepository;
import br.com.neki.projeto.service.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/usuario")
	public List<Usuario> listarUsuario(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/usuarioPorId/{id}")
	public ResponseEntity<Usuario> listarUsuarioUnico(@PathVariable Integer id) {
		Optional<Usuario> usuario = Optional.ofNullable(usuarioService.findById(id));
		if(usuario.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(usuario.get());
	}
	
	@PostMapping("/cadastrarUsuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario cadastrarUsuario(@RequestBody UsuarioDTO dto) {
		return usuarioService.save(dto);
	}
	
	@PutMapping("/atualizarUsuario/{id}")
	public Usuario atualizarUsuario(@RequestBody UsuarioDTO dto, @PathVariable Integer id) {
		Usuario usuario = usuarioService.findById(id);
		return usuarioService.update(usuario, dto);
	}
	
	@DeleteMapping("deletarUsuario/{id}")
	public void deletarUsuario(@PathVariable Integer id) {
		usuarioService.delete(id);
	}

	/*@PostMapping("/login")
	private Usuario login(@RequestBody Usuario usuario){
		return usuarioService.login(usuario);
	}*/

}
