package com.doodling.member.controller;

import com.doodling.member.dto.MyInfoResponseDTO;
import com.doodling.member.dto.ChangePasswordDTO;

import com.doodling.member.dto.ReissueTokenDTO;
import com.doodling.member.dto.TokenDTO;
import com.doodling.member.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.doodling.member.dto.LoginRequestDTO;
import com.doodling.member.service.MemberService;

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
		memberService.register(dto);

		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<Boolean> login(HttpServletResponse response, @RequestBody LoginRequestDTO request) {
		TokenDTO tokenDTO = authService.login(request);
		response.setHeader(AUTHORIZATION_HEADER, PREFIX + tokenDTO.getAccessToken());
		response.setHeader(REFRESH_HEADER, PREFIX + tokenDTO.getAccessToken());

		return ResponseEntity.ok(true);
	}

	@PostMapping("/refresh")
	public ResponseEntity<TokenDTO> reissueToken(@RequestBody ReissueTokenDTO reissueTokenDto) {
		return ResponseEntity.ok(memberService.reissueToken(reissueTokenDto));
	}

	@DeleteMapping("/{memberId}")
	public ResponseEntity<Boolean> withdraw(@PathVariable Integer memberId) {
		return ResponseEntity.ok(memberService.deleteUser(memberId));
	}

	@GetMapping("/myinfo/{memberId}")
	public ResponseEntity<MyInfoResponseDTO> myInfo(@PathVariable Integer memberId) {
		return ResponseEntity.ok(memberService.getMyInfo(memberId));

	@PatchMapping("/password/{memberId}")
	public ResponseEntity<Boolean> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO, @PathVariable Integer memberId) {
		return ResponseEntity.ok(memberService.changePassword(memberId, changePasswordDTO));

	}
}
