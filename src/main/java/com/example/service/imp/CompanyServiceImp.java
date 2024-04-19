package com.example.service.imp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CompanyDTO;
import com.example.models.Company;
import com.example.repo.CompanyRepo;
import com.example.service.CompanyService;

@Service
public class CompanyServiceImp implements CompanyService {
	@Autowired
	private CompanyRepo companyRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public CompanyDTO saveCompany(CompanyDTO companyDTO) {
		// TODO Auto-generated method stub
		Company com = new Company();
		com.setName(companyDTO.getName());
		com.setCity(companyDTO.getCity());
		Company company = companyRepo.save(com);
		CompanyDTO comDto = mapper.map(company, CompanyDTO.class);
		return comDto;
	}

}
