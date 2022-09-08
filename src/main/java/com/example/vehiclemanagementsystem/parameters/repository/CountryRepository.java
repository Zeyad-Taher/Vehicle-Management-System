package com.example.vehiclemanagementsystem.parameters.repository;

import com.example.vehiclemanagementsystem.parameters.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country,Integer> {

}
