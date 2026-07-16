CREATE DATABASE IF NOT EXISTS Hibernate_EscuelaBloqueII;
USE Hibernate_EscuelaBloqueII;

CREATE TABLE IF NOT EXISTS Cursos (
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(50));

CREATE TABLE IF NOT EXISTS  Alumnos (
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(50),
apellido VARCHAR(50),
edad INT,
curso_id INT,
CONSTRAINT fk_curso FOREIGN KEY (curso_id) REFERENCES Cursos(id) 
    ON DELETE SET NULL ON UPDATE CASCADE 
);
INSERT INTO `Hibernate_EscuelaBloqueII`.`Cursos` (`id`, `nombre`) VALUES ('1', 'DAM1');
INSERT INTO `Hibernate_EscuelaBloqueII`.`Cursos` (`id`, `nombre`) VALUES ('2', 'DAM2');
INSERT INTO `Hibernate_EscuelaBloqueII`.`Cursos` (`id`, `nombre`) VALUES ('3', 'BATXI');


INSERT INTO `Hibernate_EscuelaBloqueII`.`Alumnos` (`nombre`, `apellido`, `edad`, `curso_id`) VALUES ('Alumno1', 'Apellido1', '18', '1');
INSERT INTO `Hibernate_EscuelaBloqueII`.`Alumnos` (`nombre`, `apellido`, `edad`, `curso_id`) VALUES ('Alumno2', 'Apellido2', '19', '1');
INSERT INTO `Hibernate_EscuelaBloqueII`.`Alumnos` (`nombre`, `apellido`, `edad`, `curso_id`) VALUES ('Alumno3', 'Apellido3', '21', '2');
INSERT INTO `Hibernate_EscuelaBloqueII`.`Alumnos` (`nombre`, `apellido`, `edad`, `curso_id`) VALUES ('Alumno4', 'Apellido4', '21', '2');
INSERT INTO `Hibernate_EscuelaBloqueII`.`Alumnos` (`nombre`, `apellido`, `edad`, `curso_id`) VALUES ('Alumno5', 'Apellido5', '20', '2');

