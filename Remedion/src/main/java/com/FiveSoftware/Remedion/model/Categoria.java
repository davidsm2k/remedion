package com.FiveSoftware.Remedion.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity 
@Table(name = "tb_categoria") //define que essa classe será uma tabela do banco de dados
public class Categoria {
	@Id // chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY ) //auto incremento
	private long id;
	
	@NotNull // valor não pode ser nulo
	@Size(max = 255) // tamanho maximo de caracteres
	private String tipo;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;
	
	//metodos de acesso gets e sets
	public long getId() {
		return id;
	}
	/**
	public void setId(long id) {
		this.id = id;
	}
	**/
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public List<Produto> getProduto() {
		return produto;
	}
	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
}
