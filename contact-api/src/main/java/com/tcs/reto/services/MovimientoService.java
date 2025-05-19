package com.tcs.reto.services;

import com.tcs.reto.entities.Movimiento;

import java.util.List;
import java.util.Optional;

public interface MovimientoService {
	//CRUD Movimiento
    List<Movimiento> getAllTransactions();
    Optional<Movimiento> getTransactionById(Long id);
    Movimiento createTransaction(Movimiento transaction) throws Exception;
    Movimiento updateTransaction(Long id, Movimiento transaction);
    void deleteTransaction(Long id);
}