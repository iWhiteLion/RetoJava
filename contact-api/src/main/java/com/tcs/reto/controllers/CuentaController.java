package com.tcs.reto.controllers;

import com.tcs.reto.entities.Cuenta;
import com.tcs.reto.services.CuentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tcs.reto.bindings.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/cuentas") // Endpoint http://localhost:8080/cuentas
public class CuentaController {

    private final CuentaService accountService;

    public CuentaController(CuentaService accountService){
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllAccounts() {
        List<Cuenta> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(ApiResponse.success(accounts));
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<ApiResponse> getAccountByNumber(@PathVariable("accountNumber") String accountNumber) {
        return accountService.getAccountByNumber(accountNumber)
                .map(account -> ResponseEntity.ok(ApiResponse.success(account)))
                .orElse(ResponseEntity.status(404).body(ApiResponse.notFound("Cuenta no encontrada")));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createAccount(@RequestBody Cuenta account) {
        Cuenta created = accountService.createAccount(account);
        return ResponseEntity.status(201).body(ApiResponse.success(created));
    }

    @PutMapping("/{accountNumber}")
    public ResponseEntity<ApiResponse> updateAccount(@PathVariable("accountNumber") String accountNumber, @RequestBody Cuenta account) {
        try {
            Cuenta updated = accountService.updateAccount(accountNumber, account);
            return ResponseEntity.ok(ApiResponse.success(updated));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(ApiResponse.notFound("Cuenta no encontrada"));
        }
    }

    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<ApiResponse> deleteAccount(@PathVariable("accountNumber") String accountNumber) {
        try {
            accountService.deleteAccount(accountNumber);
            return ResponseEntity.ok(ApiResponse.success(null));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(ApiResponse.notFound("Cuenta no encontrada o no se puede eliminar"));
        }
    }
}
