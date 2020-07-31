package com.cognizant.ormlearn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.ormlearn.service.CountryService;

@Controller
@RequestMapping("country")
public class CountryController {

	@Autowired
	CountryService countryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "country/index";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	@ResponseBody
	public List<String> search(HttpServletRequest request) {
		System.out.println("output  " + countryService.searchCountry(request.getParameter("term")));
		return countryService.searchCountry(request.getParameter("term"));
	}
}
