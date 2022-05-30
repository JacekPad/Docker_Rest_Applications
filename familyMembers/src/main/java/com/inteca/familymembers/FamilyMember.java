package com.inteca.familymembers;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@ToString
public class FamilyMember {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    Long id;
    private String givenName;
    private String familyName;
    private int age;
    private Long familyId;


}
