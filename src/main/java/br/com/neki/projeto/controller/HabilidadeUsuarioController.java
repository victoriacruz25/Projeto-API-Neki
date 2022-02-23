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

import br.com.neki.projeto.entity.HabilidadeUsuario;
import br.com.neki.projeto.entity.DTO.HabilidadeUsuarioDTO;
import br.com.neki.projeto.repository.HabilidadeUsuarioRepository;
import br.com.neki.projeto.service.HabilidadeUsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
public class HabilidadeUsuarioController {
	
	@Autowired
	private HabilidadeUsuarioRepository habilidadeUsuarioRepository;
	
	@Autowired
	private HabilidadeUsuarioService habilidadeUsuarioService;
	
	@GetMapping("/habilidadeUsuario")
	@ApiOperation(value = "Listar Habilidades do Usuário ", notes = "Listar Habilidades do Usuário")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " Habilidades do Usuário listados com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public List<HabilidadeUsuario> listarHabilidadeUsuario(){
		return habilidadeUsuarioRepository.findAll();
	}
	
	@GetMapping("/habilidadeUsuarioPorId/{id}")
	@ApiOperation(value = "Buscar habilidade usuário por ID", notes = "Buscar habilidado do usuário por ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidade do usuário encontrado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<HabilidadeUsuario> listarHabilidadeUsuarioUnica(@PathVariable Integer id) {
		Optional<HabilidadeUsuario> habilidadeUsu = Optional.ofNullable(habilidadeUsuarioService.findById(id));
		if(habilidadeUsu.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(habilidadeUsu.get());
	}
	
	@PostMapping("/cadastrarHabilidadeUsuario")
	@ApiOperation(value = "Cadastrar Habilidades do Usuário ", notes = "Cadastrar Habilidades do Usuário")
	@ApiResponses(value = { @ApiResponse(code = 200, message = " Habilidades do Usuário Cadastradas com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	@ResponseStatus(HttpStatus.CREATED)
	public HabilidadeUsuario cadastrarHabilidadeUsuario(@RequestBody HabilidadeUsuarioDTO dto) {
		return habilidadeUsuarioService.save(dto);
	}
	
	@PutMapping("/atualizarHabilidadeUsuario/{id}")
	@ApiOperation(value = "Atualizar habilidade usuário por ID", notes = "Atualizar habilidado do usuário por ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidade do usuário atualizada com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public HabilidadeUsuario atualizarHabilidadeUsuario(@RequestBody HabilidadeUsuarioDTO dto, @PathVariable Integer id) {
		HabilidadeUsuario habilidadeUsu = habilidadeUsuarioService.findById(id);
		return habilidadeUsuarioService.update(habilidadeUsu, dto);
	}
	
	@DeleteMapping("deletarHabilidadeUsuario/{id}")
	@ApiOperation(value = "Excluir habilidade usuário por ID", notes = "Excluir habilidado do usuário por ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidade do usuário excluída com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public void deletarHabilidadeUsuario(@PathVariable Integer id) {
		habilidadeUsuarioService.delete(id);
	}
	
	@GetMapping("/habilidadePorIdUsuario/{id}")
	public List<HabilidadeUsuario> habilidadePorIdUsuario(@PathVariable Integer id) {
		return habilidadeUsuarioService.findByUsuario(id);
	}
		
	

}
