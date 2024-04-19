package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.EmployeeDTO;
import com.example.dto.EmployeeDTO1;

@Service
public interface EmployeeService {
	EmployeeDTO1 saveEmployee(EmployeeDTO empDto);

	List<EmployeeDTO1> getEmployee(Long minAge, Long maxAge, Long minSalary, Long maxSalary);

}
