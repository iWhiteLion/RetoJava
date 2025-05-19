package com.tcs.reto.controllers;

import com.tcs.reto.entities.Cuenta;
import com.tcs.reto.services.CuentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    private final CuentaService accountService;

    public CuentaController(CuentaService accountService){
        this.accountService = accountService;
    }

    @GetMapping
    public List<Cuenta> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Cuenta> getAccountByNumber(@PathVariable String accountNumber) {
        return accountService.getAccountByNumber(accountNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cuenta createAccount(@RequestBody Cuenta account) {
        return accountService.createAccount(account);
    }

    @PutMapping("/{accountNumber}")
    public ResponseEntity<Cuenta> updateAccount(@PathVariable String accountNumber, @RequestBody Cuenta account) {
        try {
            Cuenta updated = accountService.updateAccount(accountNumber, account);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String accountNumber) {
        accountService.deleteAccount(accountNumber);
        return ResponseEntity.noContent().build();
    }

}
