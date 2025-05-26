package com.tcs.reto.services.impl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.tcs.reto.entities.Cliente;
import com.tcs.reto.entities.Persona;

public class ClienteTest {

    @Test
    void testClienteSettersGetters() {
        Cliente cliente = new Cliente();
        Persona persona = new Persona();
        
        cliente.setClientId(1);
        cliente.setPerson(persona);
        cliente.setPassword("pass123");
        cliente.setStatus(true);

        assertEquals(1, cliente.getClientId());
        assertEquals(persona, cliente.getPerson());
        assertEquals("pass123", cliente.getPassword());
        assertTrue(cliente.getStatus());
    }

    @Test
    void testClienteDefaultStatus() {
        Cliente cliente = new Cliente();
        assertTrue(cliente.getStatus(), "El estado por defecto debe ser true");
    }
}
