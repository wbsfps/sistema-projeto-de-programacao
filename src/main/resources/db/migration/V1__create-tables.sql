CREATE TABLE animais (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    raca VARCHAR(255),
    data_nascimento DATE,
    ativo BOOLEAN
);

CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(255),
    senha VARCHAR(255)
);

CREATE TABLE vacinas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_popular VARCHAR(100),
    nome_tecnico VARCHAR(100),
    texto_restricoes VARCHAR(500)
);

CREATE TABLE aplicacoes_vacinas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_aplicacao DATE
);