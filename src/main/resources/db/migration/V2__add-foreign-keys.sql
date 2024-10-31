
ALTER TABLE aplicacoes_vacinas
ADD COLUMN id_vacina BIGINT,
ADD CONSTRAINT fk_aplicacao_vacina
FOREIGN KEY (id_vacina) REFERENCES vacinas(id);


ALTER TABLE aplicacoes_vacinas
ADD COLUMN id_animal BIGINT,
ADD CONSTRAINT fk_aplicacao_animal
FOREIGN KEY (id_animal) REFERENCES animais(id);


ALTER TABLE aplicacoes_vacinas
ADD COLUMN id_usuario BIGINT,
ADD CONSTRAINT fk_aplicacao_usuario
FOREIGN KEY (id_usuario) REFERENCES usuarios(id);
