package com.example.soapservice;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
@RequiredArgsConstructor
public class CountryEndpoint {
    public static final String NAMESPACE_URI = "http://soapservice.example.com";
    private final CountryRepo countryRepo;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();

        CountryModel countryModel = countryRepo.findByName(request.name);
        Country country = new Country();
        country.setId(countryModel.getId());
        country.setName(countryModel.getName());
        country.setPopulation(countryModel.getPopulation());
        country.setCapital(countryModel.getCapital());
        response.setCountry(country);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountriesRequest")
    @ResponsePayload
    public GetCountriesResponse getCountries() {
        GetCountriesResponse response = new GetCountriesResponse();

        List<CountryModel> data = countryRepo.findAll();
        List<Country> countries = data.stream().map(x -> {
            Country country = new Country();
            country.setId(x.getId());
            country.setCurrency(x.getCurrency());
            country.setCapital(x.getCapital());
            country.setName(x.getName());
            country.setPopulation(x.getPopulation());
            return country;
        }).toList();
        response.getCountries().addAll(countries);
        return response;
    }
}
