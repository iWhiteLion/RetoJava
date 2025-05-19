package com.tcs.reto.services.impl;

import com.tcs.reto.entities.Cuenta;
import com.tcs.reto.entities.Movimiento;
import com.tcs.reto.enums.TypeMovementEnum;
import com.tcs.reto.repositories.CuentaRepository;
import com.tcs.reto.repositories.MovimientoRepository;
import com.tcs.reto.services.MovimientoService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovimientoServiceImpl implements MovimientoService {

    private final MovimientoRepository movimientoRepository;
    private final CuentaRepository cuentaRepository;

    @Override
    public List<Movimiento> getAllTransactions() {
        return movimientoRepository.findAll();
    }

    @Override
    public Movimiento createTransaction(Movimiento movimiento) {
        String numeroCuenta = movimiento.getCuenta().getNumeroCuenta();

        Cuenta cuenta = cuentaRepository.findByNumeroCuenta(numeroCuenta)
            .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        BigDecimal saldoActual = cuenta.getSaldo();
        BigDecimal monto = movimiento.getValor();

        if (movimiento.getTipoMovimiento().equals(TypeMovementEnum.RETIRO.name()) &&
            saldoActual.compareTo(monto) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }

        BigDecimal nuevoSaldo;
        if (movimiento.getTipoMovimiento().equals(TypeMovementEnum.RETIRO.name())) {
            nuevoSaldo = saldoActual.subtract(monto);
        } else {
            nuevoSaldo = saldoActual.add(monto);
        }

        cuenta.setSaldo(nuevoSaldo);
        cuentaRepository.save(cuenta);

        movimiento.setFecha(LocalDateTime.now());
        movimiento.setSaldo(nuevoSaldo);

        return movimientoRepository.save(movimiento);
    }

    @Override
    public Optional<Movimiento> getTransactionById(Long id) {
        return movimientoRepository.findById(id);
    }

    @Override
    public Movimiento updateTransaction(Long id, Movimiento transaction) {
        Movimiento existing = movimientoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));

        existing.setValor(transaction.getValor());
        existing.setTipoMovimiento(transaction.getTipoMovimiento());

        return movimientoRepository.save(existing);
    }

    @Override
    public void deleteTransaction(Long id) {
        Movimiento movimiento = movimientoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));
        movimientoRepository.delete(movimiento);
    }
}
