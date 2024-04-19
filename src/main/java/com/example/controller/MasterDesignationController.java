package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.MasterDesignationDTO;
import com.example.service.MasterDesignationService;

@RestController
@RequestMapping("/master-designation")
public class MasterDesignationController {
	@Autowired
	private MasterDesignationService masterDesignationService;

	@PostMapping("/save")
	public MasterDesignationDTO saveMasterDesignation(@RequestBody MasterDesignationDTO masterDesignationDTO) {
		return masterDesignationService.saveMasterDesignation(masterDesignationDTO);
	}

	@GetMapping("/get-all-data")
	public List<MasterDesignationDTO> getAll() {
		return masterDesignationService.getAll();
	}
}