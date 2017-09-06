package com.example.demo;

import static com.example.demo.Country.of;
import static com.neovisionaries.i18n.CountryCode.FR;
import static com.neovisionaries.i18n.CountryCode.UK;
import static com.neovisionaries.i18n.CountryCode.US;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication implements CommandLineRunner {

    private final CountryCriterionRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        CountryCriterion countryCriterion = new CountryCriterion();
        countryCriterion.addCountries(of(UK), of(FR), of(US));
        repo.save(countryCriterion);
    }
}
