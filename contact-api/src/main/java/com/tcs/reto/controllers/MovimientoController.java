package com.tcs.reto.controllers;

import com.tcs.reto.entities.Movimiento;
import com.tcs.reto.services.MovimientoService;
import com.tcs.reto.bindings.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos") // Endpoint http://localhost:8080/movimientos
public class MovimientoController {

    private final MovimientoService movimientoService;

    public MovimientoController(MovimientoService movimientoService){
        this.movimientoService = movimientoService;
    }

    // METODO GET GENERAL (OBTENER MOVIMIENTOS)
    @GetMapping
    public ResponseEntity<ApiResponse> getAllMovimientos() {
        List<Movimiento> movimientos = movimientoService.getAllTransactions();
        return ResponseEntity.ok(ApiResponse.success(movimientos));
    }

 // METODO GET POR ID DE MOVIMIENTO (OBTENER MOVIMIENTO POR ID)
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getMovimientoById(@PathVariable("id") Long id) {
        return movimientoService.getTransactionById(id)
                .map(movimiento -> ResponseEntity.ok(ApiResponse.success(movimiento)))
                .orElse(ResponseEntity.status(404).body(ApiResponse.notFound("Movimiento no encontrado")));
    }

    //METODO POST (CREAR MOVIMIENTO)
    @PostMapping
    public ResponseEntity<ApiResponse> createMovimiento(@RequestBody Movimiento movimiento) {
        try {
            Movimiento created = movimientoService.createTransaction(movimiento);
            return ResponseEntity.status(201).body(ApiResponse.success(created));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiResponse.error(e.getMessage()));
        }
    }

    
    //METODO DELETE (BORRAR MOVIMIENTO)
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteMovimiento(@PathVariable("id") Long id) {
        try {
            movimientoService.deleteTransaction(id);
            return ResponseEntity.ok(ApiResponse.success(null));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(ApiResponse.notFound("Movimiento no encontrado o no se puede eliminar"));
        }
    }
}
