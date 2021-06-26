--liquibase formatted sql

--changeset dionatan:1
CREATE TABLE IF NOT EXISTS tipo1 (
 	id SERIAL NOT NULL,
	descricao VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
);
--rollback DROP TABLE tipo1;

