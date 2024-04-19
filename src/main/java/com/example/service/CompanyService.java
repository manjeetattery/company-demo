package com.example.service;

import org.springframework.stereotype.Service;

import com.example.dto.CompanyDTO;

@Service
public interface CompanyService {

	CompanyDTO saveCompany(CompanyDTO companyDTO);

}
