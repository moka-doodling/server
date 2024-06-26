package com.doodling.member.service;

import com.doodling.exception.CustomException;
import com.doodling.member.domain.Member;
import com.doodling.member.dto.LoginResponseDTO;
import com.doodling.member.dto.TokenDTO;
import com.doodling.member.mapper.MemberMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.doodling.member.dto.LoginRequestDTO;
import com.doodling.security.jwt.JwtTokenProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

import static com.doodling.exception.ErrorCode.MEMBER_NOT_FOUND;

/**
 * 인증 관련 로직
 *
 * @author 김지수
 * @since 2024.6.17
 * @version 1.0
 *
 * <pre>
 * 수정일        수정자        수정내용
 * ----------  --------    ---------------------------
 * 2024.6.17  김지수         최초 생성
 * </pre>
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    private final MemberMapper memberMapper;

	/**
	 * 로그인 회원 기반, access token 발급
	 * @param request
	 * @return 로그인 성공 후, 회원 정보 기반으로 생성한 access token, refresh token
	 */
    @Transactional
    @Override
    public LoginResponseDTO login(LoginRequestDTO request) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword());
        log.info("auth token: " + authenticationToken.getName() + " " + authenticationToken.getCredentials());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        Optional<Member> optionalMember = memberMapper.findByUsername(request.getUsername());
        optionalMember.orElseThrow(() -> new CustomException(MEMBER_NOT_FOUND));

        TokenDTO tokenDTO = jwtTokenProvider.generateToken(authentication);
        return LoginResponseDTO.builder()
                .memberId(optionalMember.get().getMemberId())
                .accessToken(tokenDTO.getAccessToken())
                .refreshToken(tokenDTO.getRefreshToken())
                .build();
    }
}
