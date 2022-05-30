package com.inteca.family;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<Family, Long> {

    Family findByFamilyName(String familyName);
}
