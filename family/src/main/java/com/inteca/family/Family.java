package com.inteca.family;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Family {
//Entity for the database
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String familyName;
    private int nrOfInfants;
    private int nrOfChildren;
    private int nrOfAdults;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return nrOfInfants == family.nrOfInfants && nrOfChildren == family.nrOfChildren && nrOfAdults == family.nrOfAdults && id.equals(family.id) && familyName.equals(family.familyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, familyName, nrOfInfants, nrOfChildren, nrOfAdults);
    }

    public Family(String familyName, int nrOfInfants, int nrOfChildren, int nrOfAdults) {
        this.familyName = familyName;
        this.nrOfInfants = nrOfInfants;
        this.nrOfChildren = nrOfChildren;
        this.nrOfAdults = nrOfAdults;
    }
}