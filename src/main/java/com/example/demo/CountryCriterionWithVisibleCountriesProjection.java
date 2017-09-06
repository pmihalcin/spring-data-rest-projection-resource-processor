package com.example.demo;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = {CountryCriterion.class}, name = "withCountries")
public interface CountryCriterionWithVisibleCountriesProjection {

    List<Country> getCountries();
}
