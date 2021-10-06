package com.medicalcenter.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
}
