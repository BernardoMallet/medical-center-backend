package com.medicalcenter.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medicalcenter.dto.PatientDTO;
import com.medicalcenter.enums.ActiveOrInactiveEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

	@Id
	private String cpf;
	private String name;
	private String phone;
	private String address;
	private String number;
	private String neighborhood;
	private String complement;
	private String city;
	private String state;
	
	private String obs;
	
	@Enumerated(EnumType.STRING)
	private ActiveOrInactiveEnum status;
	
	@ManyToOne
	@JoinColumn(name = "id_doctor")
	private Doctor doctor;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Transient
	@JsonIgnore
	private final ModelMapper modelMapper = new ModelMapper();

	public Patient from(PatientDTO e) {
		Patient map = this.modelMapper.map(e, Patient.class);
		return map;
	}
}
