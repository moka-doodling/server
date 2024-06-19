package com.doodling.member.service;

import com.doodling.exception.CustomException;
import com.doodling.member.domain.Member;
import com.doodling.member.mapper.MemberMapper;
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

import java.util.Optional;

import static com.doodling.exception.ErrorCode.MEMBER_NOT_FOUND;

@RequiredArgsConstructor
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider jwtTokenProvider;

  private final MemberMapper memberMapper;

	@Transactional
	@Override
	public TokenDTO login(LoginRequestDTO request) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				request.getUsername(), request.getPassword());
		log.info("auth token: " + authenticationToken.getName() + " " + authenticationToken.getCredentials());
		Authentication authentication = authenticationManager.authenticate(authenticationToken);

		Optional<Member> optionalMember = memberMapper.findByUsername(request.getUsername());
		optionalMember.orElseThrow(() -> new CustomException(MEMBER_NOT_FOUND));

		return jwtTokenProvider.generateToken(authentication);
	}
}
