package com.doodling.member.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.doodling.member.dto.LoginRequestDTO;
import com.doodling.member.dto.TokenDTO;
import com.doodling.security.jwt.JwtTokenProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider jwtTokenProvider;

	@Transactional
	@Override
	public TokenDTO login(LoginRequestDTO request) {
		log.info("[auth service] : " + request.toString());
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				request.getUsername(), request.getPassword());
		log.info("auth token: " + authenticationToken.getName() + " " + authenticationToken.getCredentials());
		Authentication authentication = authenticationManager.authenticate(authenticationToken);
		log.info("authentication: " + authentication);

		TokenDTO tokenDTO = jwtTokenProvider.generateToken(authentication);

		log.info("token DTO: {}", tokenDTO.toString());

		return tokenDTO;
	}
}
