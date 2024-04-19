package com.example.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.DesignationDTO;
import com.example.models.Company;
import com.example.models.Designation;
import com.example.models.MasterDesignation;
import com.example.repo.CompanyRepo;
import com.example.repo.DesignationRepo;
import com.example.repo.MasterDesignationRepo;
import com.example.service.DesignationService;

@Service
public class DesignationServiceImp implements DesignationService {
	@Autowired
	private DesignationRepo designationRepo;
	@Autowired
	private MasterDesignationRepo masterDesignationRepo;
	@Autowired
	private CompanyRepo companyRepo;

	@Override
	public void saveDesignation(DesignationDTO designationDto) {
		List<Long> MasterDesignIds = designationDto.getMasterDesignationId();
		List<MasterDesignation> data = masterDesignationRepo.findAllByIdIn(MasterDesignIds);
		List<Designation> designationList = new ArrayList<Designation>();
		Long comId = designationDto.getCompanyId();
		Company com = companyRepo.findById(comId).get();
		for (MasterDesignation md : data) {
			System.out.println("md:   " + md);
			Designation design1 = new Designation();
			design1.setDesignation(md);
			design1.setCompany(com);
			designationList.add(design1);
		}

		designationRepo.saveAll(designationList);

		/*
		 * Designation design1 = new Designation(); design1.setDesignation(data);
		 */
		/*
		 * for (MasterDesignation md : data) { System.out.println("md:  " + md);
		 * Designation design1 = new Designation(); design1.setDesignation(md); Long
		 * CompanyId = designationDto.getCompanyId(); Company com =
		 * companyRepo.findById(CompanyId).get(); design1.setCompany(com);
		 * designationRepo.save(design1); }
		 * 
		 */
	}
}
