package com.FiveSoftware.Remedion.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name="tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max = 255)
	private String nome;
	
	@NotNull
	private int estoque;
	
	@NotNull
	@Size(max = 255)
	private String descricao;
	
	@NotNull
	@Size(max = 255)
	private String posto;
	
	@NotNull
	@Size(max = 255)
	private String municipio_cidade;
	
	@NotNull
	@Size(max = 255)
	private String zona;
	
	@NotNull
	@Size(max = 255)
	private String endereco;

	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;
	
	public long getId() {
		return id;
	}
	
	/**
	public void setId(long id) {
		this.id = id;
	}
	**/
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPosto() {
		return posto;
	}

	public void setPosto(String posto) {
		this.posto = posto;
	}

	public String getMunicipio_cidade() {
		return municipio_cidade;
	}

	public void setMunicipio_cidade(String municipio_cidade) {
		this.municipio_cidade = municipio_cidade;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}
