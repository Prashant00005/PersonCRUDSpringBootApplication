package com.accela.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accela.entities.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
    
    
}