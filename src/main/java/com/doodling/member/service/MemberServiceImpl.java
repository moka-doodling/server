package com.doodling.member.service;

import com.doodling.member.domain.Member;
import com.doodling.member.dto.ReissueTokenDTO;
import com.doodling.member.dto.TokenDTO;
import com.doodling.member.mapper.MemberMapper;
import com.doodling.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  private final MemberMapper memberMapper;
  private final JwtTokenProvider jwtTokenProvider;

  @Transactional
  @Override
  public void register(Member member) {
    log.info(member.toString());

    memberMapper
            .insert(Member.builder()
                    .memberId(member.getMemberId())
                    .password(passwordEncoder.encode(member.getPassword()))
                    .username(member.getUsername())
                    .roles(member.getRoles())
                    .build());
  }

  // refresh token 기반으로 access token 새롭게 생성
  @Override
  public TokenDTO reissueToken(ReissueTokenDTO reissueTokenDto) {
    boolean isValidRefreshToken = jwtTokenProvider.validRefreshToken(reissueTokenDto.getRefreshToken());

    if (!isValidRefreshToken) {
      /* TODO: 에러 처리 필요 */
      log.error("유효하지 않은 refresh token 입니다.");
      return null;
    }

    Optional<Member> optional_member = memberMapper.findByUsername(reissueTokenDto.getUsername());
    if (optional_member.isEmpty()) {
      /* TODO: 에러 처리 필요 */
      log.error("member 정보를 찾을 수 없습니다.");
      return null;
    }

    return TokenDTO.builder().accessToken(jwtTokenProvider.generateAccessToken(optional_member.get())).refreshToken(reissueTokenDto.getRefreshToken()).build();
  }
}