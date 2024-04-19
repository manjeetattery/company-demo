package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.DesignationDTO;
import com.example.service.DesignationService;

@RestController
@RequestMapping("/Designation")
public class DesignationController {
	@Autowired
	private DesignationService designationService;

	@PostMapping("/save")
	public String saveDesignation(@RequestBody DesignationDTO designationDto) {
		designationService.saveDesignation(designationDto);
		return "save";
	}
}