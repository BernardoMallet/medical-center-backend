package com.medicalcenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.medicalcenter.dto.PatientDTO;
import com.medicalcenter.dto.filter.PatientFilterDTO;
import com.medicalcenter.entity.Patient;
import com.medicalcenter.repository.PatientRepository;
import com.medicalcenter.specification.PatientSpecification;

@Service
public class PatientService {

	@Autowired
	private PatientRepository repository;

	public Page<Patient> getPatientsByFilter(PatientFilterDTO filter, int page) {
		Page<Patient> patientPageble = this.repository.findAll(new PatientSpecification(filter), this.getPageable(page));
		return patientPageble;

	}
	
	public void save(PatientDTO dto) {
		Patient patient = new Patient().from(dto);
		repository.save(patient);
	}

	private Pageable getPageable(int page) {
		return PageRequest.of(page, 5);
	}

}
