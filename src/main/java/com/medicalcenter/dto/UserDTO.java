package com.medicalcenter.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medicalcenter.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private Integer id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String cpf;
	
	private String gener;
	
	private String phone;
	
	private String password;
	
	@NotNull
	private String email;
	
	private Date createdAt;
	
	@Transient
	@JsonIgnore
	private final ModelMapper modelMapper = new ModelMapper();

	public UserDTO from(User e) {
		UserDTO map = this.modelMapper.map(e, UserDTO.class);
		return map;
	}

}
