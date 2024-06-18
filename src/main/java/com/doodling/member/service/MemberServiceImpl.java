package com.doodling.member.service;

import com.doodling.member.domain.Member;
import com.doodling.member.dto.MyInfoResponseDTO;

import com.doodling.member.dto.ChangePasswordDTO;
import com.doodling.member.dto.LoginRequestDTO;
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

  private final BCryptPasswordEncoder passwordEncoder;

  private final MemberMapper memberMapper;
  private final JwtTokenProvider jwtTokenProvider;

  @Transactional
  @Override
  public void register(LoginRequestDTO dto) {

    memberMapper
            .insert(Member.builder()
                    .username(dto.getUsername())
                    .password(passwordEncoder.encode(dto.getPassword()))
                    .roles("ROLE_USER")
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

  @Override
  public boolean deleteUser(Integer memberId) {
    int result = memberMapper.deleteUserByMemberId(memberId);
    log.info("삭제된 행: " + result);
    return 0 < result;
  }

  @Override
  public MyInfoResponseDTO getMyInfo(Integer memberId) {
    Optional<Member> optional_member = memberMapper.findByMemberId(memberId);
    if (optional_member.isEmpty()) {
      /* TODO: 에러 처리 필요 */
      log.error("member 정보를 찾을 수 없습니다.");
      return null;
    }

    Member member = optional_member.get();
    return MyInfoResponseDTO.builder()
            .memberId(memberId)
            .username(member.getUsername())
            .selected_cnt(member.getSelectedCnt())
            .build();
  }


  @Transactional
  public boolean changePassword(Integer memberId, ChangePasswordDTO changePasswordDTO) {
    Optional<Member> optional_member = memberMapper.findByMemberId(memberId);

    if (optional_member.isEmpty()) {
      /* TODO: 에러 처리 필요 */
      log.error("사용자를 찾지 못했습니다.");
    }

    Member member = optional_member.get();
    /* matches 메서드 인자 순서 중요 (plain text, encoded text) */
    if (!passwordEncoder.matches(changePasswordDTO.getOldPassword(), member.getPassword())) {
      /* TODO: 에러 처리 필요 */
      log.error("비밀번호가 일치하지 않습니다.");
    }

    if (!changePasswordDTO.getNewPassword().equals(changePasswordDTO.getPassword_validation())) {
      /* TODO: 에러 처리 필요 */
      log.error("비밀번호 확인에 실패했습니다.");
    }
    member.changePassword(passwordEncoder.encode(changePasswordDTO.getNewPassword()));

    return 0 < memberMapper.changePassword(member);
  }
}