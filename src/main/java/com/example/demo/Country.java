package com.example.demo;

import static com.neovisionaries.i18n.CountryCode.UNDEFINED;
import static javax.persistence.EnumType.STRING;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.neovisionaries.i18n.CountryCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.hateoas.Identifiable;

@ToString
@Getter
@Entity
public class Country implements Identifiable<String> {

    @Id
    @Column(name = "CODE", nullable = false, unique = true, updatable = false, insertable = false, length = 2)
    @Enumerated(STRING)
    private final CountryCode code;
    @Column(name = "NAME")
    private final String name;

    Country() {
        this.code = UNDEFINED;
        this.name = UNDEFINED.getName();
    }

    private Country(CountryCode code) {
        this.code = code;
        this.name = code.getName();
    }

    public static Country of(CountryCode code) {
        return new Country(code);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return code == country.code;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String getId() {
        return code.getAlpha2();
    }
}
