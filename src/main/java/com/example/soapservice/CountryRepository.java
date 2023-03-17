package com.example.soapservice;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import com.example.soapservice.Country;
import java.util.Map;

@Component
public class CountryRepository {
    private static final Map<String,Country> countries = new HashMap<>();
    @PostConstruct
    public void initData(){
        Country honduras = new Country();
        honduras.setName("Honduras");
        honduras.setCapital("Tegucigalpa");
        honduras.setPopulation(9459440);
        honduras.setCurrency(Currency.LPS);
        countries.put(honduras.getName(),honduras);
    }

}
