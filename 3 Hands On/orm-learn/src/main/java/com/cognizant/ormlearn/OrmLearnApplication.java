package com.cognizant.ormlearn;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.QuestionService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.StockService;
import com.cognizant.ormlearn.service.UserService;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;

//@ComponentScan({"com.cognizant.orm_learn.model","com.cognizant.orm_learn.repository","com.cognizant.orm_learn.service"})

@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;

	private static StockService stockService;

	private static EmployeeService employeeService;

	private static DepartmentService departmentService;

	private static SkillService skillService;

	private static UserService userServie;
	
	private static QuestionService questionService;
	
//	private static StockRepository stockRepository;

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

	private static void testStockRepository() {
		LOGGER.info("Start");
//		LOGGER.debug("Stock:{}", stockRepository.findAll());
		LOGGER.debug("Stock:{}", stockService.findAll());
		LOGGER.info("End");
	}

	private static void displayStockResultInFormate(List<Stock> list) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("+---------+------------+---------+----------+-----------+");
		System.out.println("| st_code | st_date    | st_open | st_close | st_volume |");
		System.out.println("+---------+------------+---------+----------+-----------+");
		for (Stock stock : list) {
			System.out.printf("| %-8s| %-11s| %7s | %8s | %9s |\n", stock.getCode(), formatter.format(stock.getDate()),
					stock.getOpen(), stock.getClose(), stock.getVolume());
		}
		System.out.println("+---------+------------+---------+----------+-----------+");
	}

	private static void stockByCodeAndDate() {
		LOGGER.info("Start");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			displayStockResultInFormate(stockService.stocksByCodeAndMonth("FB", formatter.parse("2019-09-01"),
					formatter.parse("2019-09-31")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("End");
	}

	private static void stockByCodeAndCloseGreaterThan() {
		LOGGER.info("Start");
		displayStockResultInFormate(stockService.stocksByCodeAndCloseGreaterThan("GOOGL", new BigDecimal(1250)));
		LOGGER.info("End");
	}

	private static void top3StockByVolume() {
		LOGGER.info("Start");
		displayStockResultInFormate(stockService.top3StockByVolume());
		LOGGER.info("End");
	}

	private static void bottom3StockByCodeAndVolume() {
		LOGGER.info("Start");
		displayStockResultInFormate(stockService.bottom3StockByCodeAndVolume("NFLX"));
		LOGGER.info("End");
	}

	private static void testGetEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("End");
	}

	private static void testUpdateEmployee() {
		Employee employee = employeeService.get(5);
		Department department = departmentService.get(3);
		employee.setDepartment(department);
		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee);
	}

	private static void testAddEmployee() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Employee employee = new Employee(10, "Vivek Jain", 10800, true, formatter.parse("1997-10-19"));
			Department department = departmentService.get(1);
			employee.setDepartment(department);
			employeeService.save(employee);
			LOGGER.debug("Employee:{}", employee);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testGetDepartment() {
		LOGGER.info("Start");
		Department department = departmentService.get(3);
		LOGGER.debug("Department:{}", department);
		LOGGER.debug("Employee:{}", department.getEmployeeList());
		LOGGER.info("End");
	}
	
	private static void testAddSkillToEmployee() {
		Employee employee = employeeService.get(1);
		Skill skill = skillService.get(3);
		Set<Skill> skillList = employee.getSkillList();
		skillList.add(skill);
		employeeService.save(employee);
	}
	
	public static void testGetAllPermanentEmployees() {
        LOGGER.info("Start");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees:{}", employees);
        employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
        LOGGER.info("End");
    }

	private static void getAverageSallary() {
		LOGGER.info("Start");
        LOGGER.debug("Average Sallary:{}", employeeService.getAverageSalary(1));
        LOGGER.info("End");
	}
	
	private static void getAllEmployee() {
		LOGGER.info("Start");
        LOGGER.debug("ALL Employee{}", employeeService.getallEmployeeNative());
        LOGGER.info("End");
	}
	
	public static void testSearchCountry() {
		LOGGER.info("Start");
        LOGGER.debug("ALL Countries{}", countryService.searchCountry("in"));
        LOGGER.info("End");
	}
	public static void main(String[] args) {
//		LOGGER.info("Inside main");
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
//		stockRepository = context.getBean(StockRepository.class);
		stockService = context.getBean(StockService.class);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);
		userServie = context.getBean(UserService.class);
		questionService = context.getBean(QuestionService.class);
		
//		userServie.getUserById(1);
//		userServie.getUserAttemptDetailFull(1, 1);
//		userServie.getUserAttemptDetail(1, 1);
//		questionService.getQuestiontionById(1);
		
//		testGetAllCountries();
//		getAllCountriesTest();
//		testAddCountry();
//		testUpdateCountryName();
//		testDeleteCountry();

//		testStockRepository();
//		stockByCodeAndDate();
//		stockByCodeAndCloseGreaterThan();
//		top3StockByVolume();
//		bottom3StockByCodeAndVolume();
//		testGetEmployee();
//		testAddEmployee();
//		testUpdateEmployee(); 
//		testGetDepartment();
//		testGetEmployee();
//		testAddSkillToEmployee();
//		testGetAllPermanentEmployees();
//		getAverageSallary();
//		getAllEmployee();
//		testSearchCountry();
	}

}
