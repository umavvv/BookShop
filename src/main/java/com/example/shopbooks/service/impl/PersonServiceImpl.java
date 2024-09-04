package com.example.shopbooks.service.impl;


import com.example.shopbooks.entity.Person;
import com.example.shopbooks.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl {
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    public List<Person> getAllEmployee() {
        return personRepository.findAll();
    }

    public Person saveEmployee(Person person) {
        return personRepository.save(person);
    }

    public String deleteEmployee(Long id) {
        personRepository.deleteById(id);
        return "Deleted Successfully";

    }
}
