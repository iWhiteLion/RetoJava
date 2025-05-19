package com.tcs.reto.services;

import com.tcs.reto.entities.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteService {
	//CRUD Cliente
    List<Cliente> getAllClients();
    Optional<Cliente> getClientById(Integer id);
    Cliente createClient(Cliente client);
    Cliente updateClient(Integer id, Cliente client);
    void deleteClient(Integer id); 
}
