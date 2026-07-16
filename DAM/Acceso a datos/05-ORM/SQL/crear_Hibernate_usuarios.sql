-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS hibernate;

-- Usar la base de datos recién creada
USE hibernate;

-- Crear la tabla usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);
