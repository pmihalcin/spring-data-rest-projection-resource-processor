package com.example.demo;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CountryRepository extends PagingAndSortingRepository<Country, CountryCode> {
}
