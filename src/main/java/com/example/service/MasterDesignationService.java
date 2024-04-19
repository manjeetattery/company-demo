package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.MasterDesignationDTO;

@Service
public interface MasterDesignationService {

	MasterDesignationDTO saveMasterDesignation(MasterDesignationDTO masterDesignationDTO);

	List<MasterDesignationDTO> getAll();

}
