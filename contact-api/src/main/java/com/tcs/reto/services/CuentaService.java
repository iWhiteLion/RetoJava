package com.tcs.reto.services;

import com.tcs.reto.entities.Cuenta;
import java.util.List;
import java.util.Optional;

public interface CuentaService {
	//CRUD Cuenta
    List<Cuenta> getAllAccounts();
    Optional<Cuenta> getAccountByNumber(String accNumber);
    Cuenta createAccount(Cuenta account);
    Cuenta updateAccount(String accNumber, Cuenta account);
    void deleteAccount(String accNumber);
}
