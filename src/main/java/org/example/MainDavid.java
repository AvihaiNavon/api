package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class MainDavid {
    public static void main(String[] args) {
        String apiUrl = "https://restcountries.com/v2/name/france";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            URL url = new URL(apiUrl);
            List<Country> countries = objectMapper.readValue(url, new TypeReference<List<Country>>() {});

            for (Country country : countries) {
                System.out.println("Name: " + country.getName());
                System.out.println("Capital: " + country.getCapital());
                System.out.println("Population: " + country.getPopulation());
                System.out.println("-----------------------------------");
                System.out.println(country.getLanguages().get(0).getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
