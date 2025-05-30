
-- =============== CREACIÓN DEL USUARIO ===============
/* ========= QUITAR ESTA LINEA PARA CREAR USUARIO =========
CREATE ROLE demo1 WITH
  LOGIN
  SUPERUSER
  INHERIT
  CREATEDB
  CREATEROLE
  NOREPLICATION
  BYPASSRLS
  PASSWORD 'demo1';
 ========= QUITAR ESTA LINEA PARA CREAR USUARIO ========= */


-- =============== CREACIÓN DE LA BASE DE DATOS ===============

-- ======== Esta linea arregla el error de "discordancia en la versión de «collation» de la base de datos patrón «template1»"
-- ALTER DATABASE template1 REFRESH COLLATION VERSION;


/* ========= QUITAR ESTA LINEA PARA CREAR BDD =========
CREATE DATABASE "reto-java"
    WITH
    OWNER = demo1
    ENCODING = 'UTF8'
    LC_COLLATE = 'es-EC'
    LC_CTYPE = 'es-EC'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = FALSE;
========= QUITAR ESTA LINEA PARA CREAR BDD ========= */

-- NOTA: SI SE REALIZA LA CREACION DE LA BDD POR MEDIO DE ESTE SCRIPT, DEBERA CONECTARSE POR GUI A LA BDD

-- =================
-- CREACIÓN DE TABLAS
-- =================

-- Tabla personas
CREATE TABLE person (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    gender VARCHAR(10),
    age INT,
    identification VARCHAR(50) UNIQUE NOT NULL,
    address VARCHAR(150),
    phone VARCHAR(20)
);

-- Tabla clientes
CREATE TABLE client (
    client_id SERIAL PRIMARY KEY,
    person_id INT NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    status BOOLEAN DEFAULT TRUE,
    CONSTRAINT fk_person FOREIGN KEY (person_id) REFERENCES person(id)
);

-- Tabla cuentas
CREATE TABLE account (
    account_number VARCHAR(50) PRIMARY KEY,
    account_type VARCHAR(50),
    initial_balance NUMERIC(15,2) DEFAULT 0,
    status BOOLEAN DEFAULT TRUE,
    client_id INT NOT NULL,
    CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES client(client_id) ON DELETE CASCADE
);

-- Tabla movimientos (transacciones)
CREATE TABLE "transaction" (
    id SERIAL PRIMARY KEY,
    date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    transaction_type VARCHAR(50),
    amount NUMERIC(15,2) NOT NULL,
    balance NUMERIC(15,2) NOT NULL,
    account_number VARCHAR(50) NOT NULL,
    CONSTRAINT fk_account FOREIGN KEY (account_number) REFERENCES account(account_number) ON DELETE CASCADE
);


-- ========================
-- INSERCIÓN DE DATOS DE PRUEBA
-- ========================

INSERT INTO person (name, gender, age, identification, address, phone) VALUES
('Juan Pérez', 'M', 30, '1234567890', 'Av. Siempre Viva 123', '0998765432'),
('María López', 'F', 25, '0987654321', 'Calle Falsa 456', '0987654321'),
('Carlos Sánchez', 'M', 40, '1122334455', 'Av. Central 789', '0976543210'),
('Ana Gómez', 'F', 35, '2233445566', 'Calle Real 101', '0965432109'),
('Luis Martínez', 'M', 28, '3344556677', 'Av. Libertad 202', '0954321098');

INSERT INTO client (person_id, password, status) VALUES
(1, 'pass1234', TRUE),
(2, 'mypass4321', TRUE),
(3, 'securepass', TRUE),
(4, 'password', TRUE),
(5, 'admin123', TRUE);

INSERT INTO account (account_number, account_type, initial_balance, status, client_id) VALUES
('ACC123456', 'AHORROS', 1000.00, TRUE, 1),
('ACC234567', 'CORRIENTE', 2500.50, TRUE, 2),
('ACC345678', 'AHORROS', 100.00, TRUE, 3), -- CUENTA PARA PRUEBA DE FUNCIONALIDAD F3 (SALDO NO DISPONIBLE)
('ACC456789', 'CORRIENTE', 3200.75, TRUE, 4), -- CUENTA A ELIMINAR EN METODO DELETE
('ACC567890', 'AHORROS', 1500.00, TRUE, 5);

INSERT INTO "transaction" (date, transaction_type, amount, balance, account_number) VALUES
('2025-05-01 10:00:00', 'DEPOSITO', 1000.00, 1000.00, 'ACC123456'),
('2025-05-02 15:30:00', 'RETIRO', 200.00, 800.00, 'ACC123456'), 
('2025-05-03 11:00:00', 'DEPOSITO', 2500.50, 2500.50, 'ACC234567'),
('2025-05-04 09:45:00', 'RETIRO', 300.00, 2200.50, 'ACC234567'),
('2025-05-05 14:20:00', 'RETIRO', 200.00, 500.00, 'ACC345678'), --MOVIMIENTO DE PRUEBA PARA FUNCIONALIDAD F3 (SALDO NO DISPONIBLE)
('2025-05-06 12:00:00', 'DEPOSITO', 3200.75, 3200.75, 'ACC456789'),
('2025-05-07 13:30:00', 'RETIRO', 700.00, 2500.75, 'ACC456789'),
('2025-05-08 10:10:00', 'DEPOSITO', 1500.00, 1500.00, 'ACC567890');


-- ======================
-- CONSULTAS DE VERIFICACIÓN
-- ======================

SELECT * FROM "transaction";
SELECT * FROM account;
SELECT * FROM client;
SELECT * FROM person;


/* ========= QUITAR ESTA LINEA PARA BORRAR DATOS DE TABLAS ==============

-- Borrar todos los datos de cada tabla
TRUNCATE TABLE "transaction" RESTART IDENTITY CASCADE;
TRUNCATE TABLE account RESTART IDENTITY CASCADE;
TRUNCATE TABLE client RESTART IDENTITY CASCADE;
TRUNCATE TABLE person RESTART IDENTITY CASCADE;

========= QUITAR ESTA LINEA PARA BORRAR DATOS DE TABLAS ============== */




/* ========= QUITAR ESTA LINEA PARA BORRAR TABLAS ==============
DROP TABLE IF EXISTS "transaction" CASCADE;
DROP TABLE IF EXISTS account CASCADE;
DROP TABLE IF EXISTS client CASCADE;
DROP TABLE IF EXISTS person CASCADE;

========= QUITAR ESTA LINEA PARA BORRAR TABLAS ============== */ 
