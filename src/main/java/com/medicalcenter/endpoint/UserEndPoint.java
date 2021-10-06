package com.medicalcenter.endpoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicalcenter.dto.LoginDTO;
import com.medicalcenter.dto.UserDTO;
import com.medicalcenter.exception.BadRequestException;
import com.medicalcenter.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserEndPoint {

	private UserService userService;

	@Autowired
	public UserEndPoint(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/login")
	public UserDTO doLogin(@Valid @RequestBody LoginDTO loginDTO, BindingResult result) {

		if (result.hasErrors()) {
			throw new BadRequestException("Campos Obrigatórios não enviados.");
		}

		UserDTO user = this.userService.doLogin(loginDTO.getUsername(), loginDTO.getPassword());

		return user;
	}

	@PostMapping
	public void save(@Valid @RequestBody UserDTO userDto, BindingResult result) {

		if (result.hasErrors()) {
			throw new BadRequestException("Campos Obrigatórios não enviados.");
		}
		this.userService.save(userDto);
	}

}
