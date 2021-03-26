--liquibase formatted sql

--changeset dionatan:1
INSERT INTO usuario(nome,login, senha, x) VALUES ('yNot','admin', '$2a$10$ggNAyXt0LQEcAh4GkHUpp.rcd5xCYHLSEBZ6S.xAUOe04yqQeTrp2','A');
--roolback DELETE FROM usuario WHERE id_usuario=id_usuario;
