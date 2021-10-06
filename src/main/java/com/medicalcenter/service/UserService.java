package com.medicalcenter.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalcenter.dto.UserDTO;
import com.medicalcenter.entity.User;
import com.medicalcenter.exception.LoginException;
import com.medicalcenter.exception.ObjectNotFoundException;
import com.medicalcenter.repository.UserRepository;
import com.medicalcenter.util.StringUtil;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public void save(UserDTO userDTO) {
		User user = new User().from(userDTO);
		user.setPassword(StringUtil.encodeBase64(user.getPassword()));
		this.repository.save(user);
	}

	public UserDTO doLogin(String username, String password) {

		try {
			UserDTO user = this.getUserByEmail(username);
			
			if (StringUtil.decodeBase64(user.getPassword()).equalsIgnoreCase(password))
				return user;

			throw new LoginException("Login or Password Invalid");
		} catch (ObjectNotFoundException e) {
			throw new LoginException("Login or Password Invalid");
		}
	}

	public UserDTO getUserByEmail(String email) {
		Optional<User> userOptional = this.repository.findByEmail(email);
		User user = userOptional.orElseThrow(() -> new ObjectNotFoundException("Doctor not Found with email " + email));
		return new UserDTO().from(user);
	}

	public UserDTO getUserById(Integer id) {
		Optional<User> userOptional = this.repository.findById(id);
		User user = userOptional.orElseThrow(() -> new ObjectNotFoundException("Doctor not Found with " + id));
		return new UserDTO().from(user);
	}

}
