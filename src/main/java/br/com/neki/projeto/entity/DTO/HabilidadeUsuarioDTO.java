package br.com.neki.projeto.entity.DTO;

import java.time.LocalDate;

import br.com.neki.projeto.entity.Habilidade;
import br.com.neki.projeto.entity.Usuario;

public class HabilidadeUsuarioDTO {
	
	private Long id;
	private Usuario usuario;
	private Habilidade habilidade;
	private Integer nivel;
	private LocalDate dataCriacao;
	private LocalDate dataAtualizacao;
	

	public HabilidadeUsuarioDTO() {
		super();
	}

	public HabilidadeUsuarioDTO(Long id, Usuario usuario, Habilidade habilidade, Integer nivel, LocalDate dataCriacao,
			LocalDate dataAtualizacao) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.habilidade = habilidade;
		this.nivel = nivel;
		this.dataCriacao = dataCriacao;
		this.dataAtualizacao = dataAtualizacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Habilidade getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(Habilidade habilidade) {
		this.habilidade = habilidade;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
}
