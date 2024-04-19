package com.example.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.MasterDesignation;

@Repository
public interface MasterDesignationRepo extends CrudRepository<MasterDesignation, Long> {

	List<MasterDesignation> findAllByIdIn(List<Long> masterDesignIds);

}
