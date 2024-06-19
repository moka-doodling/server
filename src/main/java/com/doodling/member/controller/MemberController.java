package com.doodling.member.controller;

import com.doodling.member.dto.*;

import com.doodling.member.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.doodling.member.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
	public ResponseEntity<Integer> signup(@RequestBody SignupRequestDTO signupRequestDTO) {
		return ResponseEntity.ok(memberService.register(signupRequestDTO));
	}

	@PostMapping("/login")
	public ResponseEntity<Boolean> login(HttpServletResponse response, @RequestBody LoginRequestDTO loginRequestDTO) {
		TokenDTO tokenDTO = authService.login(loginRequestDTO);
		response.setHeader(AUTHORIZATION_HEADER, PREFIX + tokenDTO.getAccessToken());
		response.setHeader(REFRESH_HEADER, PREFIX + tokenDTO.getRefreshToken());
		return ResponseEntity.ok(true);
	}

	@PostMapping("/refresh")
	public ResponseEntity<TokenDTO> reissueToken(@RequestBody ReissueTokenDTO reissueTokenDTO) {
		return ResponseEntity.ok(memberService.reissueToken(reissueTokenDTO));
	}

	@DeleteMapping("/{memberId}")
	public ResponseEntity<Boolean> withdraw(HttpServletRequest request, @PathVariable Integer memberId) {
		String refreshToken = request.getHeader(REFRESH_HEADER);
		log.info("refresh token at member controller: {}", refreshToken);
		memberService.deleteUser(memberId, refreshToken);
		return ResponseEntity.ok(true);
	}

	@GetMapping("/myinfo/{memberId}")
	public ResponseEntity<MyInfoResponseDTO> myInfo(@PathVariable Integer memberId) {
		return ResponseEntity.ok(memberService.getMyInfo(memberId));
	}

	@PatchMapping("/password/{memberId}")
	public ResponseEntity<Integer> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO, @PathVariable Integer memberId) {
		memberService.changePassword(memberId, changePasswordDTO);
		return ResponseEntity.ok(memberId);
	}

	@GetMapping("/{memberId}/mypages")
	public ResponseEntity<List<MySubmissionResponseDTO>> myAllSubmissions(@PathVariable Integer memberId, @RequestParam("filtering") String filtering) {
		return ResponseEntity.ok(memberService.getAllMySubmissions(memberId, filtering));
	}
}
