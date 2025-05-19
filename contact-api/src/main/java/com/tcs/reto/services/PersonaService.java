// PersonService.java
package com.tcs.reto.services;

import com.tcs.reto.entities.Persona;
import com.tcs.reto.repositories.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    private final PersonaRepository personRepository;

    public PersonaService(PersonaRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Persona> findAll() {
        return personRepository.findAll();
    }

    public Optional<Persona> findById(Long id) {
        return personRepository.findById(id);
    }

    public Persona save(Persona person) {
        return personRepository.save(person);
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
