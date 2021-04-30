package com.FiveSoftware.Remedion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name="tb_usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@NotNull
	@Size(max = 255)
	private String nome_completo;
	
	@NotNull
	@Size(max = 255)
	private String email;
	
	@NotNull
	@Size(max = 255)
	private String senha;

	public long getId() {
		return id;
	}
	/**
	public void setId(long id) {
		this.id = id;
	}
	**/
	public String getNome_completo() {
		return nome_completo;
	}

	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
