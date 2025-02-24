-- Desativar temporariamente as constraints para limpar os dados
TRUNCATE cidade, cozinha, estado, forma_pagamento, grupo, grupo_permissao, permissao,
         produto, restaurante, restaurante_forma_pagamento, usuario, usuario_grupo
         RESTART IDENTITY CASCADE;

-- Inserindo dados na tabela cozinha
INSERT INTO cozinha (id, nome) VALUES
    (1, 'Tailandesa'),
    (2, 'Indiana'),
    (3, 'Argentina'),
    (4, 'Brasileira');

SELECT MAX(id) FROM cozinha;
SELECT SETVAL('cozinha_id_seq', (SELECT MAX(id) FROM cozinha));

-- Inserindo dados na tabela estado
INSERT INTO estado (id, nome) VALUES
    (1, 'Minas Gerais'),
    (2, 'São Paulo'),
    (3, 'Ceará');

-- Inserindo dados na tabela cidade
INSERT INTO cidade (id, nome, estado_id) VALUES
    (1, 'Uberlândia', 1),
    (2, 'Belo Horizonte', 1),
    (3, 'São Paulo', 2),
    (4, 'Campinas', 2),
    (5, 'Fortaleza', 3);

-- Inserindo dados na tabela restaurante
INSERT INTO restaurante (id, nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao,
                         endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro)
VALUES
    (1, 'Thai Gourmet', 10, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1, '38400-999', 'Rua João Pinheiro', '1000', 'Centro'),
    (2, 'Thai Delivery', 9.50, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL, NULL, NULL, NULL),
    (3, 'Tuk Tuk Comida Indiana', 15, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL, NULL, NULL, NULL),
    (4, 'Java Steakhouse', 12, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL, NULL, NULL, NULL),
    (5, 'Lanchonete do Tio Sam', 11, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL, NULL, NULL, NULL),
    (6, 'Bar da Maria', 6, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, NULL, NULL, NULL, NULL, NULL);

SELECT MAX(id) FROM restaurante;
SELECT SETVAL('restaurante_id_seq', (SELECT MAX(id) FROM restaurante));

-- Inserindo dados na tabela forma_pagamento
INSERT INTO forma_pagamento (id, descricao) VALUES
    (1, 'Cartão de crédito'),
    (2, 'Cartão de débito'),
    (3, 'Dinheiro');

-- Inserindo dados na tabela permissao
INSERT INTO permissao (id, nome, descricao) VALUES
    (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas'),
    (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');

-- Inserindo dados na tabela restaurante_forma_pagamento
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) VALUES
    (1, 1), (1, 2), (1, 3), (2, 3), (3, 2), (3, 3),
    (4, 1), (4, 2), (5, 1), (5, 2), (6, 3);

-- Inserindo dados na tabela produto
INSERT INTO produto (nome, descricao, preco, ativo, restaurante_id) VALUES
    ('Porco com molho agridoce', 'Deliciosa carne suína ao molho especial', 78.90, true, 1),
    ('Camarão tailandês', '16 camarões grandes ao molho picante', 110, true, 1),
    ('Salada picante com carne grelhada', 'Salada de folhas com cortes finos de carne bovina grelhada e nosso molho especial de pimenta vermelha', 87.20, true, 2),
    ('Garlic Naan', 'Pão tradicional indiano com cobertura de alho', 21, true, 3),
    ('Murg Curry', 'Cubos de frango preparados com molho curry e especiarias', 43, true, 3),
    ('Bife Ancho', 'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé', 79, true, 4),
    ('T-Bone', 'Corte muito saboroso, com um osso em formato de T, sendo de um lado o contrafilé e do outro o filé mignon', 89, true, 4),
    ('Sanduíche X-Tudo', 'Sandubão com muito queijo, hamburger bovino, bacon, ovo, salada e maionese', 19, true, 5),
    ('Espetinho de Cupim', 'Acompanha farinha, mandioca e vinagrete', 8, true, 6);