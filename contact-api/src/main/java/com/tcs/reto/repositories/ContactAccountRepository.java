package com.tcs.reto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tcs.reto.entities.ContactAccount;

public interface ContactAccountRepository extends JpaRepository<ContactAccount, Long> {

	@Modifying
	@Query(value = "UPDATE ContactAccount a SET a.number = :newNumber WHERE a.pk = :pk")
	int updateNumber(@Param("pk") Long pk,@Param("newNumber") String newNumber);
}
