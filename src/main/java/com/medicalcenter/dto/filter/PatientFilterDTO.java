package com.medicalcenter.dto.filter;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientFilterDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String cpf;
	private String name;
	private String doctorName;
	

}
