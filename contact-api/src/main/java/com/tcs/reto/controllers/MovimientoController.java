package com.tcs.reto.controllers;

import com.tcs.reto.entities.Movimiento;
import com.tcs.reto.services.MovimientoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    private final MovimientoService MovimientoService;

    public MovimientoController(MovimientoService MovimientoService){
        this.MovimientoService = MovimientoService;
    }

    @GetMapping
    public List<Movimiento> getAllMovimientos() {
        return MovimientoService.getAllTransactions();
    }

//Se debe usar >>>>>>@PathVariable ("id")Long id<<<<<<<<  para que postman reconozca el endpoint /{id}
    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> getMovimientoById(@PathVariable ("id")Long id) {
        return MovimientoService.getTransactionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createMovimiento(@RequestBody Movimiento Movimiento) {
        try {
            Movimiento created = MovimientoService.createTransaction(Movimiento);
            return ResponseEntity.ok(created);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
//Se debe usar >>>>>>@PathVariable ("id")Long id<<<<<<  para que postman reconozca el endpoint /{id}
    @PutMapping("/{id}")
    public ResponseEntity<Movimiento> updateMovimiento(@PathVariable ("id") Long id, @RequestBody Movimiento Movimiento) {
        try {
            Movimiento updated = MovimientoService.updateTransaction(id, Movimiento);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
//Se debe usar >>>>>>@PathVariable ("id")Long id<<<<<<<<  para que postman reconozca el endpoint /{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimiento(@PathVariable ("id")Long id) {
        MovimientoService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
