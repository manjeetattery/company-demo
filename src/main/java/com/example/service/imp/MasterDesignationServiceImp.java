package com.example.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.MasterDesignationDTO;
import com.example.models.MasterDesignation;
import com.example.repo.MasterDesignationRepo;
import com.example.service.MasterDesignationService;

@Service
public class MasterDesignationServiceImp implements MasterDesignationService {
	@Autowired
	private MasterDesignationRepo masterDesignationRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public MasterDesignationDTO saveMasterDesignation(MasterDesignationDTO masterDesignationDTO) {
		MasterDesignation masterDesignation = new MasterDesignation();
		masterDesignation.setName(masterDesignationDTO.getName());
		MasterDesignation masterDesign = masterDesignationRepo.save(masterDesignation);
		MasterDesignationDTO masterDesignationDto = mapper.map(masterDesign, MasterDesignationDTO.class);
		return masterDesignationDto;
	}

	@Override
	public List<MasterDesignationDTO> getAll() {
		List<MasterDesignation> masterDesignationList = (List<MasterDesignation>) masterDesignationRepo.findAll();
		List<MasterDesignationDTO> masterDesignationDtoList = masterDesignationList.stream()
				.map(user -> mapper.map(user, MasterDesignationDTO.class)).collect(Collectors.toList());
		return masterDesignationDtoList;
	}

}
