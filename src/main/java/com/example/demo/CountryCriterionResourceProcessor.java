package com.example.demo;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CountryCriterionResourceProcessor implements ResourceProcessor<Resource<CountryCriterion>> {

    @NonNull
    private final EntityLinks entityLinks;


    @Override
    public Resource<CountryCriterion> process(Resource<CountryCriterion> resource) {

        CountryCriterion countryCriterion = resource.getContent();
        resource.add(entityLinks.linkForSingleResource(countryCriterion).slash("/edit").withRel("edit"));
        return resource;
    }
}
