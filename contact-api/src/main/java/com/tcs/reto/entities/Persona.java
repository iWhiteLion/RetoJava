package com.tcs.reto.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "person")
@Data //Getters y Setters
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "gender", length = 10)
    private String gender;

    @Column(name = "age")
    private Integer age;

    @Column(name = "identification", nullable = false, unique = true, length = 50)
    private String dni;

    @Column(name = "address", length = 150)
    private String address;

    @Column(name = "phone", length = 20)
    private String phone;
}
