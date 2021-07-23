package com.accela.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accela.entities.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
    
    List<Person> findByFname(String fname);
    
    
}