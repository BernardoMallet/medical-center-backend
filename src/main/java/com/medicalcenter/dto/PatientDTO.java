package com.medicalcenter.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medicalcenter.entity.Patient;
import com.medicalcenter.enums.ActiveOrInactiveEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String cpf;
	@NotNull
	private String name;
	private String phone;
	private String address;
	private String number;
	private String neighborhood;
	private String complement;
	private String city;
	private String state;
	
	private String obs;
	
	private ActiveOrInactiveEnum status;
	private DoctorDTO doctor;
	
	private Date createdAt;
	
	@Transient
	@JsonIgnore
	private final ModelMapper modelMapper = new ModelMapper();

	public PatientDTO from(Patient e) {
		PatientDTO map = this.modelMapper.map(e, PatientDTO.class);
		return map;
	}
}
