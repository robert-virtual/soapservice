package com.example.soapservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<CountryModel,Long> {
    Country findByName(String name);
}
