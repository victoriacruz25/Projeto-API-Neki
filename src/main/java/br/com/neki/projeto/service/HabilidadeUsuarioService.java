package br.com.neki.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.projeto.entity.HabilidadeUsuario;
import br.com.neki.projeto.entity.DTO.HabilidadeUsuarioDTO;
import br.com.neki.projeto.repository.HabilidadeUsuarioRepository;

@Service
public class HabilidadeUsuarioService {

	@Autowired
	private HabilidadeUsuarioRepository habilidadeUsuarioRepository;
	
	public List<HabilidadeUsuario> findAll() {
		return habilidadeUsuarioRepository.findAll();
	}
	
	public HabilidadeUsuario save(HabilidadeUsuarioDTO dto) {
		HabilidadeUsuario habilidadeUsu = new HabilidadeUsuario();
		habilidadeUsu.setUsuario(dto.getUsuario());
		habilidadeUsu.setHabilidade(dto.getHabilidade());
		habilidadeUsu.setNivel(dto.getNivel());
		habilidadeUsu.setDataCriacao(dto.getDataCriacao());
		habilidadeUsu.setDataAtualizacao(dto.getDataAtualizacao());
		return habilidadeUsuarioRepository.save(habilidadeUsu);
	}
	
	public HabilidadeUsuario findById(Integer id) {
		Optional<HabilidadeUsuario> entity = habilidadeUsuarioRepository.findById(id);
			if (entity.isPresent()) {
				return entity.get();
			}
			
			throw new RuntimeException();
	}
	
	public HabilidadeUsuario update(HabilidadeUsuario habilidadeUsuario, HabilidadeUsuarioDTO dto) {
		HabilidadeUsuario habilidadeUsu = new HabilidadeUsuario();
		habilidadeUsu.setUsuario(dto.getUsuario());
		habilidadeUsu.setHabilidade(dto.getHabilidade());
		habilidadeUsu.setNivel(dto.getNivel());
		habilidadeUsu.setDataCriacao(dto.getDataCriacao());
		habilidadeUsu.setDataAtualizacao(dto.getDataAtualizacao());
		return habilidadeUsuarioRepository.save(habilidadeUsu);
	}
	
	public void delete(Integer id) {
		habilidadeUsuarioRepository.deleteById(id);
	}
	
	public List<HabilidadeUsuario> findByUsuario(Integer id) {
		List<HabilidadeUsuario> entity = habilidadeUsuarioRepository.findByUsuario(id);
		return entity;
	}

}
