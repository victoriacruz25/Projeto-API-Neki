package br.com.neki.projeto.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="user_skill")
public class HabilidadeUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="skill_id")
	private Habilidade habilidade;
	
	@Column(name="knowledge_level", nullable = false)
	private Integer nivel;
	
	@Column(name="created_at", nullable = false)
	private LocalDate dataCriacao;
	
	@Column(name="updated_at", nullable = false)
	private LocalDate dataAtualizacao;
	
	

	public HabilidadeUsuario() {
		super();
	}

	public HabilidadeUsuario(Integer id, Usuario usuario, Habilidade habilidade, Integer nivel, LocalDate dataCriacao,
			LocalDate dataAtualizacao) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.habilidade = habilidade;
		this.nivel = nivel;
		this.dataCriacao = dataCriacao;
		this.dataAtualizacao = dataAtualizacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
