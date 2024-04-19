package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.EmployeeDTO;
import com.example.dto.EmployeeDTO1;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/save")
	public EmployeeDTO1 saveEmployee(@RequestBody EmployeeDTO empDto) {
		return employeeService.saveEmployee(empDto);
	}

	@GetMapping("/get-employee")
	public List<EmployeeDTO1> getEmployee(@RequestParam Long minAge, @RequestParam Long maxAge,
			@RequestParam Long minSalary, @RequestParam Long maxSalary) {
		return employeeService.getEmployee(minAge, maxAge, minSalary, maxSalary);
	}
}