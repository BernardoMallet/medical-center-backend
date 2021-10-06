package com.medicalcenter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalcenter.dto.DoctorDTO;
import com.medicalcenter.entity.Doctor;
import com.medicalcenter.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository repository;

	public void save(DoctorDTO dto) {
		Doctor entity = new Doctor().from(dto);
		this.repository.save(entity);
	}
	
	public List<DoctorDTO> getAllDoctors(){
		List<Doctor> allEntities = this.repository.findAll();
		List<DoctorDTO> dtos = new ArrayList<>();
		allEntities.forEach(entity -> dtos.add(new DoctorDTO().from(entity)));
		return dtos;
	}
	
}
