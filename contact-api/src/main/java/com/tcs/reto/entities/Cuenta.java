package com.tcs.reto.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data //Getters y Setters
@Table(name = "account") //Nombre de la tabla
public class Cuenta {

    @Id
    @Column(name = "account_number", length = 50)
    private String numeroCuenta; 

    @Column(name = "account_type", nullable = false, length = 50)
    private String tipoCuenta;

    @Column(name = "initial_balance", nullable = false, precision = 15, scale = 2)
    private BigDecimal saldo;

    @Column(name = "status")
    private Boolean status = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Cliente cliente;

}
