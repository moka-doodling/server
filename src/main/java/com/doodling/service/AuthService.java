package com.doodling.service;

import com.doodling.dto.LoginRequestDTO;
import com.doodling.dto.TokenDTO;

public interface AuthService {

  TokenDTO login(LoginRequestDTO request);
}
