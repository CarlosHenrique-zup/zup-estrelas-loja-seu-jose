CREATE DATABASE estoque;

CREATE TABLE estoque.pecas (
codigo_de_barras VARCHAR(5) PRIMARY KEY NOT NULL,
nome VARCHAR(100) NOT NULL,
modelo_do_carro VARCHAR(30) NOT NULL,
fabricante VARCHAR(15) NOT NULL,
preco_de_custo DECIMAL(10, 2) UNSIGNED NOT NULL,
preco_de_venda DECIMAL(10, 2) UNSIGNED NOT NULL,
qtd_em_estoque INT UNSIGNED DEFAULT 0,
categoria ENUM('funilaria', 'motor', 'performance', 'som') NOT NULL);

DESC estoque.pecas;

INSERT INTO estoque.pecas (
codigo_de_barras,
nome,
modelo_do_carro,
fabricante,
preco_de_custo,
preco_de_venda,
qtd_em_estoque,
categoria)
VALUES
('123', 'Carburador', 'Tempra', 'FIAT', 400, 600, 5, 'motor'),
('234', 'Injeção Eletronica', 'Gol', 'VW', 500, 700, 3, 'motor'),
('000', 'Paralama', 'Toro', 'FIAT', 2000, 3000, 7, 'funilaria'),
('111', 'Auto Falantes JBL', 'Palio', 'Fiat', 3500, 4200, 2, 'som'),
('467', 'Filtro de ar esportivo', 'Lancer', 'Mitsubishi', 1000, 1500, 2, 'performance');

SELECT * FROM estoque.pecas;