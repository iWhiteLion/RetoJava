package com.tcs.reto.services.impl;

import com.tcs.reto.entities.Cuenta;
import com.tcs.reto.repositories.CuentaRepository;
import com.tcs.reto.services.CuentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CuentaServiceImpl implements CuentaService {

    private final CuentaRepository cuentaRepository;

    @Override
    public List<Cuenta> getAllAccounts() {
        return cuentaRepository.findAll();
    }

    @Override
    public Optional<Cuenta> getAccountByNumber(String numeroCuenta) {
        return cuentaRepository.findByNumeroCuenta(numeroCuenta);
    }

    @Override
    public Cuenta createAccount(Cuenta account) {
        return cuentaRepository.save(account);
    }

    @Override
    public Cuenta updateAccount(String numeroCuenta, Cuenta updatedAccount) {
    	Cuenta existing = cuentaRepository.findByNumeroCuenta(numeroCuenta)
            .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        existing.setTipoCuenta(updatedAccount.getTipoCuenta());
        existing.setSaldo(updatedAccount.getSaldo());

        return cuentaRepository.save(existing);
    }
    @Override
    public void deleteAccount(String numeroCuenta) {
    	Cuenta account = cuentaRepository.findByNumeroCuenta(numeroCuenta)
            .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        cuentaRepository.delete(account);
    }
}
