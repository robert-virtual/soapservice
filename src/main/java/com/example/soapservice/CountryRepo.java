package com.example.soapservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<CountryModel,Long> {
    CountryModel findByName(String name);
}
