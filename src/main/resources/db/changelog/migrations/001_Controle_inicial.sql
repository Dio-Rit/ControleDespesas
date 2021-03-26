--liquibase formatted sql

--changeset dionatan:1
CREATE TABLE IF NOT EXISTS usuario (
 	id_usuario SERIAL NOT NULL,
	nome VARCHAR(100) NOT NULL,
	login VARCHAR(30) NOT NULL,
	senha VARCHAR(200) NOT NULL,
	x VARCHAR(1),
	PRIMARY KEY (id_usuario)
);
--rollback DROP TABLE usuario;


--changeset dionatan:2
CREATE TABLE IF NOT EXISTS categoria (
 	id_categoria SERIAL NOT NULL,
	nome VARCHAR(100) NOT NULL,
	descricao VARCHAR(300),
	x VARCHAR(1),
	PRIMARY KEY (id)
);
--rollback DROP TABLE categoria;


--changeset dionatan:3
CREATE TABLE IF NOT EXISTS pessoa (
  	id_pessoa SERIAL NOT NULL,
	nome VARCHAR(100) NOT NULL,
	cpf VARCHAR(14),
	x VARCHAR(1),
	PRIMARY KEY (id)
);
--rollback DROP TABLE pessoa;


--changeset dionatan:4
CREATE TABLE IF NOT EXISTS movimento (
  	id_movimento SERIAL NOT NULL,
	data DATE,
	tipo VARCHAR(50) NOT NULL,
	categoria VARCHAR(100) NOT NULL,
	valor DECIMAL (10,2) NOT NULL,
	descricao VARCHAR(300),
	x VARCHAR(1),
	categoria_id INT NOT NULL,
	pessoa_id INT NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT fk_movimento_categoria FOREIGN KEY (categoria_id) REFERENCES categoria(id),
	CONSTRAINT fk_movimento_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
);
--rollback DROP TABLE movimento;