package com.tcs.reto.services;

import java.util.List;

import com.tcs.reto.dto.ContactDto;

public interface ContactPhoneService {

	List<ContactDto> findAll();

	void delete(String phoneNumber);

	int updateNumber(String phoneNumber, String newNumber);
}
