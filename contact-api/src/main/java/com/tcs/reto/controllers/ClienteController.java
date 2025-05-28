package com.tcs.reto.controllers;

import com.tcs.reto.entities.Cliente;
import com.tcs.reto.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tcs.reto.bindings.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/clientes") // Endpoint http://localhost:8080/clientes
public class ClienteController {

    private final ClienteService clientService;

    public ClienteController(ClienteService clientService){
        this.clientService = clientService;
    }

    // METODO GET GENERAL (OBTENER CLIENTES)
    @GetMapping
    public ResponseEntity<ApiResponse> getAllClients() {
        List<Cliente> clients = clientService.getAllClients();
        return ResponseEntity.ok(ApiResponse.success(clients));
    }

    // METODO GET POR ID DE CLIENTE (OBTENER CLIENTE POR ID)
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getClientById(@PathVariable("id") Integer id) {
        return clientService.getClientById(id)
            .map(cliente -> ResponseEntity.ok(ApiResponse.success(cliente)))
            .orElse(ResponseEntity.status(404).body(ApiResponse.notFound("Cliente no encontrado")));
    }

    //METODO POST (CREAR CLIENTE)
    @PostMapping
    public ResponseEntity<ApiResponse> createClient(@RequestBody Cliente client) {
        Cliente created = clientService.createClient(client);
        return ResponseEntity.status(201).body(ApiResponse.success(created));
    }

    //METODO PUT (ACTUALIZAR UN CLIENTE)
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateClient(@PathVariable("id") Integer id, @RequestBody Cliente client) {
        try {
            Cliente updated = clientService.updateClient(id, client);
            return ResponseEntity.ok(ApiResponse.success(updated));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(ApiResponse.notFound("Cliente no encontrado"));
        }
    }

    //METODO DELETE (BORRAR CLIENTE)
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteClient(@PathVariable("id") Integer id) {
        try {
            clientService.deleteClient(id);
            return ResponseEntity.ok(ApiResponse.success(null));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(ApiResponse.notFound("Cliente no encontrado o no se puede eliminar"));
        }
    }
}
