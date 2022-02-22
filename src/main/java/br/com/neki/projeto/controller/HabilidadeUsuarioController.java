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

@RestController
@RequestMapping("/api")
public class HabilidadeUsuarioController {
	
	@Autowired
	private HabilidadeUsuarioRepository habilidadeUsuarioRepository;
	
	@Autowired
	private HabilidadeUsuarioService habilidadeUsuarioService;
	
	@GetMapping("/habilidadeUsuario")
	public List<HabilidadeUsuario> listarHabilidadeUsuario(){
		return habilidadeUsuarioRepository.findAll();
	}
	
	@GetMapping("/habilidadeUsuarioPorId/{id}")
	public ResponseEntity<HabilidadeUsuario> listarHabilidadeUsuarioUnica(@PathVariable Integer id) {
		Optional<HabilidadeUsuario> habilidadeUsu = Optional.ofNullable(habilidadeUsuarioService.findById(id));
		if(habilidadeUsu.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(habilidadeUsu.get());
	}
	
	@PostMapping("/cadastrarHabilidadeUsuario")
	@ResponseStatus(HttpStatus.CREATED)
	public HabilidadeUsuario cadastrarHabilidadeUsuario(@RequestBody HabilidadeUsuarioDTO dto) {
		return habilidadeUsuarioService.save(dto);
	}
	
	@PutMapping("/atualizarHabilidadeUsuario/{id}")
	public HabilidadeUsuario atualizarHabilidadeUsuario(@RequestBody HabilidadeUsuarioDTO dto, @PathVariable Integer id) {
		HabilidadeUsuario habilidadeUsu = habilidadeUsuarioService.findById(id);
		return habilidadeUsuarioService.update(habilidadeUsu, dto);
	}
	
	@DeleteMapping("deletarHabilidadeUsuario/{id}")
	public void deletarHabilidadeUsuario(@PathVariable Integer id) {
		habilidadeUsuarioService.delete(id);
	}

}
