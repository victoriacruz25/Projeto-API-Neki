package br.com.neki.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.projeto.entity.Habilidade;
import br.com.neki.projeto.entity.DTO.HabilidadeDTO;
import br.com.neki.projeto.repository.HabilidadeRepository;

@Service
public class HabilidadeService {
	
	@Autowired
	private HabilidadeRepository habilidadeRepository;
	
	public List<Habilidade> findAll() {
		return habilidadeRepository.findAll();
	}
	
	public Habilidade save(HabilidadeDTO dto) {
		Habilidade habilidade = new Habilidade();
		habilidade.setNome(dto.getNome());
		habilidade.setVersao(dto.getVersao());
		habilidade.setDescricao(dto.getDescricao());
		habilidade.setImagem(dto.getImagem());
		return habilidadeRepository.save(habilidade);
	}
	
	public Habilidade findById(Integer id) {
		Optional<Habilidade> entity = habilidadeRepository.findById(id);
			if (entity.isPresent()) {
				return entity.get();
			}
			
			throw new RuntimeException();
	}
	
	public Habilidade update(Habilidade habilidade, HabilidadeDTO dto) {
		habilidade.setNome(dto.getNome());
		habilidade.setVersao(dto.getVersao());
		habilidade.setDescricao(dto.getDescricao());
		habilidade.setImagem(dto.getImagem());
		return habilidadeRepository.save(habilidade);
	}
	
	public void delete(Integer id) {
		habilidadeRepository.deleteById(id);
	}

}
