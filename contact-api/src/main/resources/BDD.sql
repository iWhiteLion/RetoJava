CREATE TABLE person (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    gender VARCHAR(10),
    age INT,
    identification VARCHAR(50) UNIQUE NOT NULL,
    address VARCHAR(150),
    phone VARCHAR(20)
);

CREATE TABLE client (
    client_id SERIAL PRIMARY KEY,
    person_id INT NOT NULL,
    password VARCHAR(100) NOT NULL,
    status BOOLEAN DEFAULT TRUE,
    CONSTRAINT fk_person FOREIGN KEY (person_id) REFERENCES person(id)
);

CREATE TABLE account (
    account_number VARCHAR(50) PRIMARY KEY,
    account_type VARCHAR(50),
    initial_balance NUMERIC(15,2) DEFAULT 0,
    status BOOLEAN DEFAULT TRUE,
    client_id INT NOT NULL,
    CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES client(client_id)
);

CREATE TABLE transaction (
    id SERIAL PRIMARY KEY,
    date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    transaction_type VARCHAR(50),
    amount NUMERIC(15,2) NOT NULL,
    balance NUMERIC(15,2) NOT NULL,
    account_number VARCHAR(50) NOT NULL,
    CONSTRAINT fk_account FOREIGN KEY (account_number) REFERENCES account(account_number)
);


