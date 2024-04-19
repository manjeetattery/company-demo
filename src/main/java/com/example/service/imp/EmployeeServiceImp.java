package com.example.service.imp;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.EmployeeDTO;
import com.example.dto.EmployeeDTO1;
import com.example.exception.UserNotFoundException;
import com.example.models.Company;
import com.example.models.Designation;
import com.example.models.Employee;
import com.example.repo.DesignationRepo;
import com.example.repo.EmployeeRepo;
import com.example.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private EmployeeRepo employeeRepo;
	@Autowired
	private DesignationRepo designationRepo;

	@Override
	public EmployeeDTO1 saveEmployee(EmployeeDTO empDto) {
		Employee emp = new Employee();
		emp.setName(empDto.getName());
		emp.setDateOfBirth(empDto.getDateOfBirth());
		emp.setSalary(empDto.getSalary());
		Designation design = designationRepo.findById(empDto.getDesignationId()).get();
		emp.setDesignation(design);
		Company com = design.getCompany();
		emp.setCompany(com);
		Employee employe = employeeRepo.save(emp);
		EmployeeDTO1 employeeDto1 = mapper.map(employe, EmployeeDTO1.class);
		return employeeDto1;

	}

	@Override
	public List<EmployeeDTO1> getEmployee(Long minAge, Long maxAge, Long minSalary, Long maxSalary) {
		LocalDate currentDate = LocalDate.now();
		// Subtract 20 years from the current date.
		if (maxSalary > minSalary && maxAge > minAge) {
			LocalDate minDateBirth = currentDate.minusYears(minAge);
			LocalDate maxDateBirth = currentDate.minusYears(maxAge);
			// Print the LocalDate object.
			System.out.println("minDateBirth: " + minDateBirth);
			System.out.println("maxDateBirth:  " + maxDateBirth);
			int minYear = minDateBirth.getYear();
			int maxYear = maxDateBirth.getYear();
			System.out.println("minYear:   " + minYear);
			System.out.println("maxYear:   " + maxYear);
			List<Employee> empList = employeeRepo.getEmploye(minYear, maxYear, minSalary, maxSalary);

			/*
			 * @Query(value = "SELECT * FROM employee where YEAR(date_of_birth)>=:maxY AND
			 * YEAR(date_of_birth)<=:minY AND employee.salary>=:minSalary AND
			 * employee.salary<=:maxSalary,nativeQuery = true) getEmploye(@parm("minY")int
			 * minYear,@parm("maxY")int max,@parm("minSal") Long
			 * minSalary,@parm("maxSalary")Long MaxSalary);
			 */

			// List<Employee> empList = employeeRepo.getEmployee(minDateBirth, maxDateBirth,
			// minSalary, maxSalary);
			List<EmployeeDTO1> empDto1 = empList.stream().map(user -> mapper.map(user, EmployeeDTO1.class))
					.collect(Collectors.toList());
			return empDto1;
		} else {
			throw new UserNotFoundException("not vaild");

		}
	}

}