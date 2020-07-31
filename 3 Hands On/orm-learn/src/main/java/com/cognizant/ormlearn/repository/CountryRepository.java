package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository(value = "countryRepository")
public interface CountryRepository extends JpaRepository<Country, String> {

	@Query("SELECT name FROM Country where name like %:keyword%")
	public List<String> search(@Param("keyword") String keyword);
}
