package com.example.demo;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true, exclude = {"countries"})
@Entity
public class CountryCriterion extends AbstractEntityWithVersionAndGeneratedId<Long> {

    @ManyToMany(cascade = {PERSIST, MERGE})
    @JoinTable(name = "MER_CRITERION_COUNTRY",
            joinColumns = @JoinColumn(name = "CRITERION_ID"),
            inverseJoinColumns = @JoinColumn(name = "COUNTRY_CODE")
    )
    private List<Country> countries = new LinkedList<>();

    public CountryCriterion() {
    }

    public void addCountries(Country... countries) {
        this.countries.addAll(Arrays.asList(countries));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryCriterion that = (CountryCriterion) o;

        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
