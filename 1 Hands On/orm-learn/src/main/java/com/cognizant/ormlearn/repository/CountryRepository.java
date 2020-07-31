package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository(value="countryRepository")
public interface CountryRepository extends JpaRepository<Country, String> {

}
