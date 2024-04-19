package com.example.service;

import org.springframework.stereotype.Service;

import com.example.dto.DesignationDTO;

@Service
public interface DesignationService {

	void saveDesignation(DesignationDTO designationDto);

}
