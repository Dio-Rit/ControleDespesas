--liquibase formatted sql

--changeset dionatan:1
INSERT INTO usuario(nome,login, senha, x) VALUES ('yNot','admin', 'admin','A');
--roolback DELETE FROM usuario WHERE id_usuario=id_usuario;
