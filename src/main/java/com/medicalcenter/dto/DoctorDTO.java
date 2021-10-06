package com.medicalcenter.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medicalcenter.entity.Doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;
	
	private String speciality;

	private Date createdAt;

	@Transient
	@JsonIgnore
	private final ModelMapper modelMapper = new ModelMapper();

	public DoctorDTO from(Doctor e) {
		DoctorDTO map = this.modelMapper.map(e, DoctorDTO.class);
		return map;
	}
}
