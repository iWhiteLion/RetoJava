package com.tcs.reto.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.math.BigDecimal;


@Entity
@Table(name = "transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "transaction_type", length = 50)
    private String tipoMovimiento;

    @Column(name = "amount", precision = 15, scale = 2, nullable = false)
    private BigDecimal valor;

    @Column(name = "balance", precision = 15, scale = 2, nullable = false)
    private BigDecimal saldo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_number", nullable = false)
    private Cuenta cuenta;
}
