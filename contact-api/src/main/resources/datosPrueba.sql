-- Insertar datos en contactaccount
INSERT INTO contactaccount (pk, bank, name, number) VALUES
(1, 'Banco de Crédito', 'Juan Pérez', '123456789'),
(2, 'Interbank', 'Ana Ramírez', '987654321'),
(3, 'Scotiabank', 'Carlos Huamán', '456789123');

-- Insertar datos en contactphone
INSERT INTO contactphone (key, bank_name, owner_name, phone_number, acc_number) VALUES
('abc123', 'BBVA', 'Juan Pérez', '999111222', '00112233'),
('def456', 'Interbank', 'Ana Ramírez', '999333444', '00445566'),
('ghi789', 'Banco Pichincha', 'Carlos Huamán', '999555666', '00778899');

