CREATE TABLE pesagem (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    peso DOUBLE,
    data_pesagem DATE,
    id_animal BIGINT,
    CONSTRAINT fk_pesagem_animal FOREIGN KEY (id_animal) REFERENCES animais(id)
);