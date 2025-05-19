package com.tcs.reto.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
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

    public String getNumeroCuenta() {
        return accNumber;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.accNumber = numeroCuenta;
    }

    public String getTipoCuenta() {
        return accType;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.accType = tipoCuenta;
    }

    public BigDecimal getSaldoInicial() {
        return initialBal;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.initialBal = saldoInicial;
    }

    public Long getIdCliente() {
        return clientID;
    }

    public void setIdCliente(Long idCliente) {
        this.clientID = idCliente;
    }
}
