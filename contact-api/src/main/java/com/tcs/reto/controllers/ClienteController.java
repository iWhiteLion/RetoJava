package com.tcs.reto.controllers;

import com.tcs.reto.entities.Cliente;
import com.tcs.reto.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes") //Endpoint http://localhost:8080/clientes
public class ClienteController {

    private final ClienteService clientService;

    public ClienteController(ClienteService clientService){
        this.clientService = clientService;
    }

    @GetMapping
    public List<Cliente> getAllClients() {
        return clientService.getAllClients();
    }
    
//Se debe usar >>>>>>@PathVariable ("id")Integer id<<<<<< para que postman reconozca el endpoint /{id}
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClientById(@PathVariable ("id")Integer id) {
        return clientService.getClientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> createClient(@RequestBody Cliente client) {
        Cliente created = clientService.createClient(client);
        return ResponseEntity.ok(created);
    }

//Se debe usar >>>>>>@PathVariable ("id")Integer id<<<<<< para que postman reconozca el endpoint /{id}
  //Metodo no valido debido a relaciones en BDD, primero de debe borrar las cuentas vinculadas
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateClient(@PathVariable  ("id") Integer id, @RequestBody Cliente client) {
        try {
        	Cliente updated = clientService.updateClient(id, client);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

//Se debe usar >>>>>>@PathVariable ("id")Integer id<<<<<< para que postman reconozca el endpoint /{id}
    //Metodo no valido debido a relaciones en BDD, primero de debe borrar las cuentas vinculadas
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable ("id") Integer id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
