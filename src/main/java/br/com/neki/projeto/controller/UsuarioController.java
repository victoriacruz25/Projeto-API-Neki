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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/Usuario")
	@ApiOperation(value = "Listar Usuários ", notes = "Listar Usuários")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuários listados com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public List<Usuario> listarUsuario(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/UsuarioPorId/{id}")
	@ApiOperation(value = "Buscar usuário por ID", notes = "Buscar usuário por ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuário encontrado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<Usuario> listarUsuarioUnico(@PathVariable Integer id) {
		Optional<Usuario> usuario = Optional.ofNullable(usuarioService.findById(id));
		if(usuario.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(usuario.get());
	}
	
	@PostMapping("/cadastrarUsuario")
	@ApiOperation(value = "Cadastrar Usuários ", notes = "Cadastar Usuários")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuários cadastrados com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario cadastrarUsuario(@RequestBody UsuarioDTO dto) {
		return usuarioService.save(dto);
	}
	
	@PutMapping("/atualizarUsuario/{id}")
	@ApiOperation(value = "Atualizar usuário por ID", notes = "Atualizar usuário por ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuário atualizado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public Usuario atualizarUsuario(@RequestBody UsuarioDTO dto, @PathVariable Integer id) {
		Usuario usuario = usuarioService.findById(id);
		return usuarioService.update(usuario, dto);
	}
	
	@DeleteMapping("deletarUsuario/{id}")
	@ApiOperation(value = "Excluir usuário por ID", notes = "Excluir usuário por ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuário excluído com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public void deletarUsuario(@PathVariable Integer id) {
		usuarioService.delete(id);
	}
	
	@PostMapping("/login")
	public UsuarioDTO Login( @RequestBody Usuario usuario) {
		return usuarioService.login(usuario.getLogin(), usuario.getSenha());
	}
	
}
