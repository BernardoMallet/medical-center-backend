package com.medicalcenter.endpoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicalcenter.dto.PatientDTO;
import com.medicalcenter.dto.filter.PatientFilterDTO;
import com.medicalcenter.entity.Patient;
import com.medicalcenter.exception.BadRequestException;
import com.medicalcenter.service.PatientService;

@CrossOrigin
@RestController
@RequestMapping("/patient")
public class PatientEndpoint {

	@Autowired
	private PatientService service;

	@PostMapping
	public ResponseEntity<Object> save(@Valid @RequestBody PatientDTO dto, BindingResult result) {
		
		if(result.hasErrors()) {
			throw new BadRequestException("Campos Obrigatórios não enviados.");
		}
		
		
		this.service.save(dto);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping("/find/filter/{page}")
	public Page<Patient> getListPatients(@RequestBody PatientFilterDTO dto, @PathVariable("page") Integer page){
		Page<Patient> patients = this.service.getPatientsByFilter(dto, page);
		return patients;
	}
}
