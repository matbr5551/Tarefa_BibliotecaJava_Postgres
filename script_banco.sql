-- EXERCÍCIO 2: MODELAGEM DO BANCO DE DADOS

-- 1. Criação da tabela item
CREATE TABLE item (
                      id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                      codigo INT NOT NULL,
                      titulo VARCHAR(255) NOT NULL,
                      tipo VARCHAR(50) CHECK (tipo IN ('livro', 'revista')) NOT NULL,
                      autor VARCHAR(255),
                      edicao VARCHAR(50),
                      disponivel BOOLEAN DEFAULT TRUE
);

-- 2. Criação da tabela usuario
CREATE TABLE usuario (
                         id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                         nome VARCHAR(255) NOT NULL,
                         tipo VARCHAR(50) CHECK (tipo IN ('aluno', 'professor')) NOT NULL,
                         limite_itens INT NOT NULL
);

-- 3. Criação da tabela emprestimo
CREATE TABLE emprestimo (
                            id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                            item_id INT NOT NULL REFERENCES item(id),
                            usuario_id INT NOT NULL REFERENCES usuario(id),
                            data_retirada DATE NOT NULL,
                            data_devolucao_prevista DATE NOT NULL,
                            data_devolucao DATE,
                            valor_multa NUMERIC(10, 2)
);

-- INSERÇÃO DE DADOS DE TESTE
INSERT INTO item (codigo, titulo, tipo, autor, edicao) VALUES
                                                           (101, 'O Senhor dos Anéis', 'livro', 'J.R.R. Tolkien', '1a'),
                                                           (102, 'Java para Iniciantes', 'livro', 'Herbert Schildt', '8a'),
                                                           (103, 'Clean Code', 'livro', 'Robert C. Martin', '1a'),
                                                           (201, 'Veja', 'revista', NULL, 'Edição 2500');

INSERT INTO usuario (nome, tipo, limite_itens) VALUES
                                                   ('Matheus', 'aluno', 3),
                                                   ('João', 'professor', 5);

INSERT INTO emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa)
VALUES (1, 1, '2023-10-01', '2023-10-15', '2023-10-12', 0.00);

INSERT INTO emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa)
VALUES (2, 2, '2023-10-25', '2023-11-08', NULL, NULL);

-- EXERCÍCIO 3: CONSULTAS SQL
-- 1. Listar todo o acervo
SELECT codigo, titulo, tipo, disponivel
FROM item;

-- 2. Listar os empréstimos em aberto
SELECT u.nome, i.titulo
FROM emprestimo e
         JOIN usuario u ON e.usuario_id = u.id
         JOIN item i ON e.item_id = i.id
WHERE e.data_devolucao IS NULL;

-- 3. Calcular o total de multas acumuladas por usuário
SELECT u.nome, SUM(e.valor_multa) AS total_multas
FROM emprestimo e
         JOIN usuario u ON e.usuario_id = u.id
GROUP BY u.nome;

-- 4. Listar os itens que nunca foram emprestados
SELECT i.codigo, i.titulo
FROM item i
         LEFT JOIN emprestimo e ON i.id = e.item_id
WHERE e.id IS NULL;