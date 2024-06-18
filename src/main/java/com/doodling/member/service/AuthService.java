package com.doodling.member.service;

import com.doodling.member.dto.LoginRequestDTO;
import com.doodling.member.dto.TokenDTO;

public interface AuthService {

  TokenDTO login(LoginRequestDTO request);
}
