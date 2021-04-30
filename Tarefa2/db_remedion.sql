CREATE DATABASE db_remedion;

USE db_remedion;

CREATE TABLE tb_usuario (
	id bigint NOT NULL AUTO_INCREMENT,
	nome_completo varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	senha varchar(255) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE tb_categoria (
	id bigint NOT NULL AUTO_INCREMENT,
	tipo varchar(255) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE tb_produto (
	id bigint NOT NULL AUTO_INCREMENT,
	categoria_id bigint NOT NULL,
	nome varchar(255) NOT NULL,
	estoque int NOT NULL,
	descricao varchar(255) NOT NULL,
	posto varchar(255) NOT NULL,
	municipio_cidade varchar(255) NOT NULL,
	zona varchar(255) NOT NULL,
	endereco varchar(255) NOT NULL,
    classificacao varchar(255) NOT NULL,
	ativo BOOLEAN NOT NULL,
	PRIMARY KEY (id),
    FOREIGN KEY(categoria_id) REFERENCES tb_categoria(id)
);