package com.example.vehiclemanagementsystem.parameters.service;

import com.example.vehiclemanagementsystem.parameters.model.Country;
import com.example.vehiclemanagementsystem.parameters.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAll(){
        return (List<Country>) countryRepository.findAll();
    }
    public void save(Country country){
        countryRepository.save(country);
    }
    public void delete(Integer id){
        countryRepository.deleteById(id);
    }

    public Country getById(Integer id) {
        return countryRepository.findById(id).orElse(null);
    }
}
