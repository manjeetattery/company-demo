package com.example.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO {
	private Long id;
	private String name;
	private Long salary;
	private LocalDate dateOfBirth;
	private Long designationId;
	private Long companyId;

}
