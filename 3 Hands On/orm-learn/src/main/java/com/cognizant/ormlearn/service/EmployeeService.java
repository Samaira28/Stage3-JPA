package com.cognizant.ormlearn.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;


@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Transactional
	public Employee get(Integer id) {
		return employeeRepository.findById(id).get();
	}
	
	@Transactional
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}
	
	@Transactional
	public List<Employee> getAllPermanentEmployees(){
		return employeeRepository.getAllPermanentEmployees();
	}
	
	@Transactional
	public double getAverageSalary(int id) {
		return employeeRepository.getAverageSalary(id);
	}

	@Transactional
	public List<Employee> getallEmployeeNative() {
		return employeeRepository.getAllEmployeesNative();
	}
}
