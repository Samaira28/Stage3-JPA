package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;

//@ComponentScan({"com.cognizant.orm_learn.model","com.cognizant.orm_learn.repository","com.cognizant.orm_learn.service"})
@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;

	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}

	private static void getAllCountriesTest() {
		LOGGER.info("Start");
		Country country;
		try {
			country = countryService.findCountryByCode("IN");
			LOGGER.debug("Country:{}", country);
		} catch (CountryNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LOGGER.info("End");
	}

	private static void testAddCountry() {
		LOGGER.info("Start");
		Country country = new Country("JV", "Java Virtual");
		countryService.addCountry(country);
		try {
			country = countryService.findCountryByCode("JV");
			LOGGER.debug("Country:{}", country);
		} catch (CountryNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("End");
	}

	private static void testUpdateCountryName() {
		LOGGER.info("Start");

		Country country;
		try {
			countryService.updateCountry("JV", "Java Vcode");
			country = countryService.findCountryByCode("JV");
			LOGGER.debug("Country:{}", country);
		} catch (CountryNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("End");
	}

	private static void testDeleteCountry() {
		LOGGER.info("Start");
		countryService.deleteCountry("JV");
		Country country;
		try {
			country = countryService.findCountryByCode("JV");
			LOGGER.debug("Country:{}", country);
		} catch (CountryNotFoundException e) {
			LOGGER.info("No Record Found");
		}
		LOGGER.info("End");
	}

	public static void main(String[] args) {
		LOGGER.info("Inside main");
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);

		// testGetAllCountries();
		// getAllCountriesTest();
		// testAddCountry();
		// testUpdateCountryName();
		testDeleteCountry();
	}

}
