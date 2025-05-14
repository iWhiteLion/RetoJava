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
@Table(name = "contactphone")
public class ContactPhone {

	@Id
	private String key;

	private String bankName;

	private String ownerName;

	private String phoneNumber;

	private String accNumber;
}

