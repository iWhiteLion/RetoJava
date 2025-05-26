package com.tcs.reto.services.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.reto.entities.Cliente;
import com.tcs.reto.entities.Persona;
import com.tcs.reto.repositories.ClienteRepository;
import com.tcs.reto.repositories.PersonaRepository;

@SpringBootTest
@Transactional
public class ClienteIntegrationTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Test
    void testGuardarYBuscarCliente() {
        Persona persona = new Persona();
        persona.setName("Juan");
        persona = personaRepository.save(persona);

        Cliente cliente = new Cliente();
        cliente.setPerson(persona);
        cliente.setPassword("clave123");
        cliente.setStatus(true);

        Cliente clienteGuardado = clienteRepository.save(cliente);

        assertThat(clienteGuardado.getClientId()).isNotNull();

        Cliente clienteRecuperado = clienteRepository.findById(clienteGuardado.getClientId()).orElse(null);
        assertThat(clienteRecuperado).isNotNull();
        assertThat(clienteRecuperado.getPerson()).isEqualTo(persona);
        assertThat(clienteRecuperado.getPassword()).isEqualTo("clave123");
        assertThat(clienteRecuperado.getStatus()).isTrue();
    }
}
