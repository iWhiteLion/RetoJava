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

    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> getMovimientoById(@PathVariable Long id) {
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

    @PutMapping("/{id}")
    public ResponseEntity<Movimiento> updateMovimiento(@PathVariable Long id, @RequestBody Movimiento Movimiento) {
        try {
            Movimiento updated = MovimientoService.updateTransaction(id, Movimiento);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovimiento(@PathVariable Long id) {
        MovimientoService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
