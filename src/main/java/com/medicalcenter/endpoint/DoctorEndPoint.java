package com.medicalcenter.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicalcenter.dto.DoctorDTO;
import com.medicalcenter.service.DoctorService;

@CrossOrigin
@RestController
@RequestMapping("/doctor")
public class DoctorEndPoint {

	@Autowired
	private DoctorService service;
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody DoctorDTO doctor){
		service.save(doctor);
		return ResponseEntity.ok("Doctor saved successfully.");
	}
	
	@GetMapping
	public ResponseEntity<Object> listAll(){
		List<DoctorDTO> allDoctors = service.getAllDoctors();
		return ResponseEntity.ok(allDoctors);
		
	}
	
}
