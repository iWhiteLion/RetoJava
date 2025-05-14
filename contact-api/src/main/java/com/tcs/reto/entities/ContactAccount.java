package com.tcs.reto.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
@Table(name = "contactaccount")
public class ContactAccount {

	private String banco;

	private String nombre;

	private String numero;

	@Id
	private Long pk;

}
