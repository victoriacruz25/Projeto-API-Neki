package br.com.neki.projeto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="skill")
public class Habilidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="name", nullable = false )
	private String nome;
	
	@Column(name="version", nullable = true)
	private String versao;
	
	@Column(name="description", nullable = false)
	private String descricao;
	
	@Column(name="image_url", nullable= true)
	private String imagem;
	
	
	public Habilidade() {
		super();
	}

	public Habilidade(Long id, String nome, String versao, String descricao, String imagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.versao = versao;
		this.descricao = descricao;
		this.imagem = imagem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	
	
	
	

}
