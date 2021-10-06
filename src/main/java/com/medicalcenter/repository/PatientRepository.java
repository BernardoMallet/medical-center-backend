package com.medicalcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.medicalcenter.entity.Patient;

@Repository
public interface PatientRepository
		extends JpaRepository<Patient, String>, PagingAndSortingRepository<Patient, String>, JpaSpecificationExecutor<Patient> {

}
