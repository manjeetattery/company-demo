package com.example.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Designation;

@Repository
public interface DesignationRepo extends CrudRepository<Designation, Long> {

}
