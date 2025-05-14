-- Tabla: contactaccount
CREATE TABLE contactaccount (
    pk BIGINT PRIMARY KEY,
    bank VARCHAR(255),
    name VARCHAR(255),
    number VARCHAR(50)
);

-- Tabla: contactphone
CREATE TABLE contactphone (
    key VARCHAR(255) PRIMARY KEY,
    bank_name VARCHAR(255),
    owner_name VARCHAR(255),
    phone_number VARCHAR(50),
    acc_number VARCHAR(50)
);
