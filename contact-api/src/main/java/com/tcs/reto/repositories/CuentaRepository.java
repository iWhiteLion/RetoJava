package com.tcs.reto.repositories;

import com.tcs.reto.entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Cuenta c SET c.numeroCuenta = :newNumber WHERE c.id = :id")
    int updateNumeroCuenta(@Param("id") Long id, @Param("newNumber") String newNumber);

    Optional<Cuenta> findByNumeroCuenta(String numeroCuenta);

    void deleteByNumeroCuenta(String numeroCuenta);
}
