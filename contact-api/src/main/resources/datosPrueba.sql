-- Datos de prueba en person
INSERT INTO person (name, gender, age, identification, address, phone) VALUES
('Juan Pérez', 'M', 30, '1234567890', 'Av. Siempre Viva 123', '0998765432'),
('María López', 'F', 25, '0987654321', 'Calle Falsa 456', '0987654321'),
('Carlos Sánchez', 'M', 40, '1122334455', 'Av. Central 789', '0976543210'),
('Ana Gómez', 'F', 35, '2233445566', 'Calle Real 101', '0965432109'),
('Luis Martínez', 'M', 28, '3344556677', 'Av. Libertad 202', '0954321098');

-- Datos de prueba en client
INSERT INTO client (person_id, password, status) VALUES
(1, 'pass1234', TRUE),
(2, 'mypass4321', TRUE),
(3, 'securepass', TRUE),
(4, 'password', TRUE),
(5, 'admin123', TRUE);

-- Datos de prueba en account
INSERT INTO account (account_number, account_type, initial_balance, status, client_id) VALUES
('ACC123456', 'AHORROS', 1000.00, TRUE, 1),
('ACC234567', 'CORRIENTE', 2500.50, TRUE, 2),
('ACC345678', 'AHORROS', 500.00, TRUE, 3),
('ACC456789', 'CORRIENTE', 3200.75, TRUE, 4),
('ACC567890', 'AHORROS', 1500.00, TRUE, 5);

-- Datos de prueba en transaction
INSERT INTO transaction (date, transaction_type, amount, balance, account_number) VALUES
('2025-05-01 10:00:00', 'DEPOSITO', 1000.00, 1000.00, 'ACC123456'),
('2025-05-02 15:30:00', 'RETIRO', 200.00, 800.00, 'ACC123456'),
('2025-05-03 11:00:00', 'DEPOSITO', 2500.50, 2500.50, 'ACC234567'),
('2025-05-04 09:45:00', 'RETIRO', 300.00, 2200.50, 'ACC234567'),
('2025-05-05 14:20:00', 'DEPOSITO', 500.00, 500.00, 'ACC345678'),
('2025-05-06 12:00:00', 'DEPOSITO', 3200.75, 3200.75, 'ACC456789'),
('2025-05-07 13:30:00', 'RETIRO', 700.00, 2500.75, 'ACC456789'),
('2025-05-08 10:10:00', 'DEPOSITO', 1500.00, 1500.00, 'ACC567890');


-- Borrar todos los datos de cada tabla
TRUNCATE TABLE transaction RESTART IDENTITY CASCADE;
TRUNCATE TABLE account RESTART IDENTITY CASCADE;
TRUNCATE TABLE client RESTART IDENTITY CASCADE;
TRUNCATE TABLE person RESTART IDENTITY CASCADE;

