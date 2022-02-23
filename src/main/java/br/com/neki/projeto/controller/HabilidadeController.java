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

import br.com.neki.projeto.entity.Habilidade;
import br.com.neki.projeto.entity.DTO.HabilidadeDTO;
import br.com.neki.projeto.repository.HabilidadeRepository;
import br.com.neki.projeto.service.HabilidadeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping ("/api")
public class HabilidadeController {

	@Autowired
	private HabilidadeRepository habilidadeRepository;
	
	@Autowired
	private HabilidadeService habilidadeService;
	
	@GetMapping("/habilidade")
	@ApiOperation(value = "Listar Habilidades ", notes = "Listar Habilidades")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidades listadas com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public List<Habilidade> listarHabilidade(){
		return habilidadeRepository.findAll();
	}
	
	@GetMapping("/habilidadePorId/{id}")
	@ApiOperation(value = "Buscar habilidade por ID", notes = "Buscar habilidade por ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidade encontrada com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<Habilidade> listarHabilidadeUnica(@PathVariable Integer id) {
		Optional<Habilidade> habilidade = Optional.ofNullable(habilidadeService.findById(id));
		if(habilidade.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(habilidade.get());
	}
	
	@PostMapping("/cadastrarHabilidade")
	@ApiOperation(value = "Cadastrar habilidade", notes = "Cadastrar habilidade")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidade inserida com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	@ResponseStatus(HttpStatus.CREATED)
	public Habilidade cadastrarHabilidade(@RequestBody HabilidadeDTO dto) {
		return habilidadeService.save(dto);
	}
	
	@PutMapping("/atualizarHabilidade/{id}")
	@ApiOperation(value = "Atualizar habilidade por ID", notes = "Atualizar habilidade por ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidade atualizada com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public Habilidade atualizarHabilidade(@RequestBody HabilidadeDTO dto, @PathVariable Integer id) {
		Habilidade habilidade = habilidadeService.findById(id);
		return habilidadeService.update(habilidade, dto);
	}
	
	@DeleteMapping("deletarHabilidade/{id}")
	@ApiOperation(value = "Excluir habilidade por ID", notes = "Excluir habilidade por ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Habilidade excluída com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public void deletarHabilidade(@PathVariable Integer id) {
		habilidadeService.delete(id);
	}
}
