-- Criar a tabela 'estado'
CREATE TABLE estado (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(80) NOT NULL
);

INSERT INTO estado (nome)
SELECT DISTINCT nome_estado FROM cidade;

ALTER TABLE cidade ADD COLUMN estado_id BIGINT NOT NULL;

UPDATE cidade
SET estado_id = (SELECT e.id FROM estado e WHERE e.nome = cidade.nome_estado);

ALTER TABLE cidade
ADD CONSTRAINT fk_cidade_estado FOREIGN KEY (estado_id) REFERENCES estado (id);

ALTER TABLE cidade DROP COLUMN nome_estado;

ALTER TABLE cidade RENAME COLUMN nome_cidade TO nome;