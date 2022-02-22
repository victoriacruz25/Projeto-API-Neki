package br.com.neki.projeto.entity.DTO;

public class HabilidadeDTO {

	private Integer id;
	private String nome;
	private String versao;
	private String descricao;
	private String imagem;
	
	public HabilidadeDTO() {
		super();
	}

	public HabilidadeDTO(Integer id, String nome, String versao, String descricao, String imagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.versao = versao;
		this.descricao = descricao;
		this.imagem = imagem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
