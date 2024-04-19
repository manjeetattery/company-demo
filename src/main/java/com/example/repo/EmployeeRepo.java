package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.models.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {
	/*
	 * @Query(value =
	 * "SELECT * FROM employee WHERE employee.date_of_birth >= :maxBirth AND employee.date_of_birth <= :minBirth AND employee.salary>=:minSalary AND employee.salary<=:maxSalary"
	 * , nativeQuery = true) List<Employee> getEmployee(@Param("minBirth") LocalDate
	 * minBirthdate, @Param("maxBirth") LocalDate maxBirthdate, @Param("minSalary")
	 * Long minSalary, @Param("maxSalary") Long maxSalary);
	 */
	@Query(value = "SELECT * FROM employee  where YEAR(date_of_birth)>=:maxY AND  YEAR(date_of_birth)<=:minY  AND employee.salary>=:minSal AND employee.salary<=:maxSalary", nativeQuery = true)
	List<Employee> getEmploye(@Param("minY") int minYear, @Param("maxY") int max, @Param("minSal") Long minSalary,
			@Param("maxSalary") Long MaxSalary);

}
