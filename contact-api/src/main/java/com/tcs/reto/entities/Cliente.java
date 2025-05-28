package com.tcs.reto.entities;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "client") //Nombre de la tabla
@Data //Getters y Setters
@NoArgsConstructor 
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Integer clientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private Persona person;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "status")
    private Boolean status = true;
}
