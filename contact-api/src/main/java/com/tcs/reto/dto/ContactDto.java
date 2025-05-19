package com.tcs.reto.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data //Getters y Setters
@Builder // Constructor
public class ContactDto {

    private String accNumber;
    private String accType;
    private BigDecimal initialBal;
    private Long clientID;

    public ContactDto() {
    }

    public ContactDto(String numeroCuenta, String tipoCuenta, BigDecimal saldoInicial, Long idCliente) {
        this.accNumber = numeroCuenta;
        this.accType = tipoCuenta;
        this.initialBal = saldoInicial;
        this.clientID = idCliente;
    }
}
