package com.doodling.controller;

import com.doodling.dto.ReissueTokenDTO;
import com.doodling.dto.TokenDTO;
import com.doodling.service.AuthService;
import org.apache.ibatis.ognl.Token;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doodling.domain.Member;
import com.doodling.dto.LoginRequestDTO;
import com.doodling.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
@Slf4j
public class MemberController {

	private final MemberService memberService;

	private final AuthService authService;

	private final static String AUTHORIZATION_HEADER = "auth";

	private final static String REFRESH_HEADER = "refresh";

	private static final String PREFIX = "Bearer ";

	@PostMapping("/sign-up")
	public ResponseEntity<String> signup(@RequestBody LoginRequestDTO dto) {
		memberService.register(
				Member.builder().username(dto.getUsername()).password(dto.getPassword()).roles("ROLE_USER").build());
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<Boolean> login(HttpServletResponse response, @RequestBody LoginRequestDTO request) {
		TokenDTO tokenDTO = authService.login(request);
		response.setHeader(AUTHORIZATION_HEADER, PREFIX + tokenDTO.getAccessToken());
		response.setHeader(REFRESH_HEADER, PREFIX + tokenDTO.getAccessToken());

		return ResponseEntity.status(HttpStatus.OK).body(true);
	}

	@PostMapping("/refresh")
	public ResponseEntity<TokenDTO> reissueToken(@RequestBody ReissueTokenDTO reissueTokenDto) {
		return  ResponseEntity.ok(memberService.reissueToken(reissueTokenDto));
	}
}
