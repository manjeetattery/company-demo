package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CompanyDTO;
import com.example.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	private CompanyService companyService;

	@PostMapping("/save")
	public CompanyDTO saveCompany(@RequestBody CompanyDTO companyDTO) {
		return companyService.saveCompany(companyDTO);
	}
}
