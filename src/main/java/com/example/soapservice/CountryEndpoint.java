package com.example.soapservice;

import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class CountryEndpoint {
    public static final String NAMESPACE_URI = "http://soapservice.example.com";
   private final CountryRepo countryRepo;

   @PayloadRoot(namespace = NAMESPACE_URI,localPart = "getCountryRequest")
   @ResponsePayload
   public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepo.findByName(request.name));
        return response;
    }
}
