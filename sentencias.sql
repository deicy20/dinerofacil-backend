
CREATE DATABASE Empresa;
USE Empresa;


CREATE TABLE DEPARTAMENTO (
    codigo INT PRIMARY KEY,
    nombre VARCHAR(100)
);


CREATE TABLE CIUDADES (
    codigo INT PRIMARY KEY,
    nombre VARCHAR(100),
    cod_departamento INT,
    FOREIGN KEY (cod_departamento) REFERENCES DEPARTAMENTO(codigo)
);


CREATE TABLE OFICINA (
    codigo INT PRIMARY KEY,
    nombre VARCHAR(100),
    cod_ciudad INT,
    gerente VARCHAR(100),
    FOREIGN KEY (cod_ciudad) REFERENCES CIUDADES(codigo)
);


CREATE TABLE PRODUCTO (
    codigo INT PRIMARY KEY,
    descripcion VARCHAR(100)
);


CREATE TABLE INVENTARIO (
    id INT PRIMARY KEY,
    cod_oficina INT,
    cod_producto INT,
    existencia INT,
    FOREIGN KEY (cod_oficina) REFERENCES OFICINA(codigo),
    FOREIGN KEY (cod_producto) REFERENCES PRODUCTO(codigo)
);


INSERT INTO DEPARTAMENTO (codigo, nombre) VALUES 
(1, 'Ventas'),
(2, 'Finanzas'),
(3, 'Recursos Humanos');


INSERT INTO CIUDADES (codigo, nombre, cod_departamento) VALUES 
(1, 'Ciudad 1', 1),
(2, 'Ciudad 2', 2),
(3, 'Ciudad 3', 3);


INSERT INTO OFICINA (codigo, nombre, cod_ciudad, gerente) VALUES 
(1, 'Oficina 1', 1, 'Juan Perez'),
(2, 'Oficina 2', 2, 'Maria Lopez'),
(3, 'Oficina 3', 3, 'Carlos Garcia');


INSERT INTO PRODUCTO (codigo, descripcion) VALUES 
(1, 'Producto 1'),
(2, 'Producto 2'),
(3, 'Producto 3');

INSERT INTO INVENTARIO (id, cod_oficina, cod_producto, existencia) VALUES 
(1, 1, 1, 50),
(2, 1, 2, 30),
(3, 2, 1, 20),
(4, 2, 3, 10),
(5, 3, 2, 40),
(6, 3, 3, 70);

-- A
SELECT 
    OFICINA.nombre 
FROM 
    OFICINA 
WHERE 
    OFICINA.gerente LIKE '%Ju%';

-- B
SELECT 
    OFICINA.nombre AS oficina, 
    CIUDADES.nombre AS ciudad, 
    DEPARTAMENTO.nombre AS departamento 
FROM 
    OFICINA 
JOIN 
    CIUDADES ON OFICINA.cod_ciudad = CIUDADES.codigo 
JOIN 
    DEPARTAMENTO ON CIUDADES.cod_departamento = DEPARTAMENTO.codigo;

-- C
SELECT 
    DISTINCT OFICINA.nombre 
FROM 
    OFICINA 
JOIN 
    INVENTARIO ON OFICINA.codigo = INVENTARIO.cod_oficina 
JOIN 
    PRODUCTO ON INVENTARIO.cod_producto = PRODUCTO.codigo 
WHERE 
    PRODUCTO.descripcion LIKE 'P%';

-- D

SELECT TOP 1 
    OFICINA.nombre 
FROM 
    OFICINA 
JOIN 
    INVENTARIO ON OFICINA.codigo = INVENTARIO.cod_oficina 
GROUP BY 
    OFICINA.nombre 
ORDER BY 
    SUM(INVENTARIO.existencia) DESC;

-- E
SELECT 
    OFICINA.nombre AS oficina, 
    CIUDADES.nombre AS ciudad, 
    PRODUCTO.descripcion AS producto, 
    INVENTARIO.existencia 
FROM 
    INVENTARIO 
JOIN 
    OFICINA ON INVENTARIO.cod_oficina = OFICINA.codigo 
JOIN 
    CIUDADES ON OFICINA.cod_ciudad = CIUDADES.codigo 
JOIN 
    PRODUCTO ON INVENTARIO.cod_producto = PRODUCTO.codigo 
WHERE 
    INVENTARIO.existencia < 20;


-- F
UPDATE 
    INVENTARIO 
SET 
    existencia = 15 
WHERE 
    cod_oficina IN (
        SELECT 
            codigo 
        FROM 
            OFICINA 
        WHERE 
            cod_ciudad = 1
    );
