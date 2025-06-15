-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS biblioteca_db;
USE biblioteca_db;

-- Tabela de bibliotecários
CREATE TABLE bibliotecario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

-- Tabela de livros
CREATE TABLE livros (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    genero VARCHAR(100) NOT NULL,
    status VARCHAR(50) DEFAULT 'Disponível',
    data_cadastro DATETIME DEFAULT CURRENT_TIMESTAMP,
    bibliotecario_id BIGINT NOT NULL,
    FOREIGN KEY (bibliotecario_id) REFERENCES bibliotecario(id) ON DELETE CASCADE
);

-- Inserção de dados de exemplo
INSERT INTO bibliotecario (nome, email) VALUES 
('Maria Silva', 'maria.silva@biblioteca.com'),
('João Santos', 'joao.santos@biblioteca.com'),
('Ana Costa', 'ana.costa@biblioteca.com');

INSERT INTO livros (titulo, autor, genero, status, bibliotecario_id) VALUES 
('Dom Casmurro', 'Machado de Assis', 'Romance', 'Disponível', 1),
('O Cortiço', 'Aluísio Azevedo', 'Romance', 'Emprestado', 1),
('Clean Code', 'Robert C. Martin', 'Técnico', 'Disponível', 2),
('O Hobbit', 'J.R.R. Tolkien', 'Fantasia', 'Reservado', 3),
('1984', 'George Orwell', 'Ficção', 'Disponível', 2);