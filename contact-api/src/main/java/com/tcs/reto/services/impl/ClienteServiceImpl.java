package com.tcs.reto.services.impl;

import com.tcs.reto.entities.Cliente;
import com.tcs.reto.repositories.ClienteRepository;
import com.tcs.reto.services.ClienteService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAllClients() {
        return clienteRepository.findAll();
    }
    @Override
    public Optional<Cliente> getClientById(Integer id) {
        return clienteRepository.findById(id);
    }
    @Override
    public Cliente updateClient(Integer id, Cliente client) {
        Cliente existing = clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        existing.getPerson().setAddress(client.getPerson().getAddress());
        existing.getPerson().setAge(client.getPerson().getAge());
        existing.getPerson().setDni(client.getPerson().getDni());
        existing.getPerson().setGender(client.getPerson().getGender());
        existing.getPerson().setName(client.getPerson().getName());
        existing.setPassword(client.getPassword());
        existing.getPerson().setPhone(client.getPerson().getPhone());
        existing.setStatus(client.getStatus());

        return clienteRepository.save(existing);
    }
    @Override
    public void deleteClient(Integer id) {
        //clienteRepository.deleteById(id);
    	 if (!clienteRepository.existsById(id)) {
    	        throw new RuntimeException("Cliente con ID " + id + " no encontrado.");
    	    }
    	    clienteRepository.deleteById(id);
    }
	@Override
	public Cliente createClient(Cliente client) {
		// TODO Auto-generated method stub
		return null;
	}

}
