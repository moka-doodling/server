package com.doodling.member.service;

import com.doodling.member.dto.LoginRequestDTO;
import com.doodling.member.dto.LoginResponseDTO;

public interface AuthService {

  LoginResponseDTO login(LoginRequestDTO request);
}
