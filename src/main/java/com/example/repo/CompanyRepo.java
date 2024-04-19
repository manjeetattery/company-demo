package com.example.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Company;

@Repository
public interface CompanyRepo extends CrudRepository<Company, Long> {

}
