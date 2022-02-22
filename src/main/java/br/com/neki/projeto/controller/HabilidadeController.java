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

@RestController
@RequestMapping ("/api")
public class HabilidadeController {

	@Autowired
	private HabilidadeRepository habilidadeRepository;
	
	@Autowired
	private HabilidadeService habilidadeService;
	
	@GetMapping("/habilidade")
	public List<Habilidade> listarHabilidade(){
		return habilidadeRepository.findAll();
	}
	
	@GetMapping("/habilidadePorId/{id}")
	public ResponseEntity<Habilidade> listarHabilidadeUnica(@PathVariable Integer id) {
		Optional<Habilidade> habilidade = Optional.ofNullable(habilidadeService.findById(id));
		if(habilidade.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(habilidade.get());
	}
	
	@PostMapping("/cadastrarHabilidade")
	@ResponseStatus(HttpStatus.CREATED)
	public Habilidade cadastrarHabilidade(@RequestBody HabilidadeDTO dto) {
		return habilidadeService.save(dto);
	}
	
	@PutMapping("/atualizarHabilidade/{id}")
	public Habilidade atualizarHabilidade(@RequestBody HabilidadeDTO dto, @PathVariable Integer id) {
		Habilidade habilidade = habilidadeService.findById(id);
		return habilidadeService.update(habilidade, dto);
	}
	
	@DeleteMapping("deletarHabilidade/{id}")
	public void deletarHabilidade(@PathVariable Integer id) {
		habilidadeService.delete(id);
	}
}
