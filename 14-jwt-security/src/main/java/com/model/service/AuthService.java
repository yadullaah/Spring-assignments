package com.model.service;

import com.model.Dto.LoginDto;
import com.model.Dto.RegistrationDto;
import com.model.entity.User;

public interface AuthService {

	User register(RegistrationDto registration);

	String login(LoginDto loginDto);

}
