package br.com.neki.projeto.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user", schema="teste_residencia")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="login", nullable= false)
	private String login;
	
	@Column(name="password", nullable= false)
	private String senha;
	
	@Column(name="last_login_date")
	private LocalDate ultimoLoginData;
	
	
	public Usuario() {
		super();
	}

	public Usuario(Integer id) {
		super();
		this.id = id;
	}

	public Usuario(Integer id, String login, String senha, LocalDate ultimoLoginData) {
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
