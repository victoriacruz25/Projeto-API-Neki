package br.com.neki.projeto.entity.DTO;

import java.time.LocalDate;

public class UsuarioDTO {

	private Integer id;
	private String login;
	private String senha;
	private LocalDate ultimoLoginData;
	
	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(Integer id, String login, String senha, LocalDate ultimoLoginData) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.ultimoLoginData = ultimoLoginData;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public LocalDate getUltimoLoginData() {
		return ultimoLoginData;
	}

	public void setUltimoLoginData(LocalDate ultimoLoginData) {
		this.ultimoLoginData = ultimoLoginData;
	}
	
}
