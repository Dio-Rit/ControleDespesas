--liquibase formatted sql

--changeset dionatan:1
CREATE TABLE IF NOT EXISTS tipo1 (
 	id SERIAL NOT NULL,
	descricao VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
);
--rollback DROP TABLE tipo1;

--changeset dionatan:2
CREATE TABLE IF NOT EXISTS tipo2 (
 	id SERIAL NOT NULL,
	descricao VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
);
--rollback DROP TABLE tipo2;

--changeset dionatan:3
CREATE TABLE IF NOT EXISTS tipo3 (
 	id SERIAL NOT NULL,
	descricao VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
);
--rollback DROP TABLE tipo3;

--changeset dionatan:4
CREATE TABLE IF NOT EXISTS tipo4 (
 	id SERIAL NOT NULL,
	descricao VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
);
--rollback DROP TABLE tipo4;

