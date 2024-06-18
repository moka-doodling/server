package com.doodling.member.service;

import com.doodling.exception.CustomException;
import com.doodling.member.domain.Member;
import com.doodling.member.dto.MyInfoResponseDTO;

import com.doodling.member.dto.ChangePasswordDTO;
import com.doodling.member.dto.LoginRequestDTO;

import com.doodling.member.dto.MySubmissionResponseDTO;

import com.doodling.member.dto.ReissueTokenDTO;
import com.doodling.member.dto.TokenDTO;
import com.doodling.member.mapper.MemberMapper;
import com.doodling.security.jwt.JwtTokenProvider;
import com.doodling.submission.domain.Submission;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.doodling.exception.ErrorCode.*;

@RequiredArgsConstructor
@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

  private final BCryptPasswordEncoder passwordEncoder;

  private final MemberMapper memberMapper;
  private final JwtTokenProvider jwtTokenProvider;

  @Override
  @Transactional
  public Integer register(LoginRequestDTO loginRequestDTO) {

    Member member = Member.builder()
            .username(loginRequestDTO.getUsername())
            .password(passwordEncoder.encode(loginRequestDTO.getPassword()))
            .roles("ROLE_USER")
            .build();
    memberMapper.insert(member);

    return member.getMemberId();
  }

  // refresh token 기반으로 access token 새롭게 생성
  @Override
  @Transactional
  public TokenDTO reissueToken(ReissueTokenDTO reissueTokenDto) {
    boolean isValidRefreshToken = jwtTokenProvider.validRefreshToken(reissueTokenDto.getRefreshToken());

    if (!isValidRefreshToken) {
      log.error("유효하지 않은 refresh 토큰입니다.");
      throw new JwtException("유효하지 않은 refresh 토큰입니다.");
    }

    Optional<Member> optional_member = memberMapper.findByUsername(reissueTokenDto.getUsername());
    if (optional_member.isEmpty()) {
      log.error("member 정보를 찾을 수 없습니다.");
      throw new CustomException(MEMBER_NOT_FOUND);
    }

    return TokenDTO.builder().accessToken(jwtTokenProvider.generateAccessToken(optional_member.get())).refreshToken(reissueTokenDto.getRefreshToken()).build();
  }

  @Override
  @Transactional
  public void deleteUser(Integer memberId) {
    int result = memberMapper.deleteUserByMemberId(memberId);
    log.info("삭제된 행: " + result);

    if (result == 0) throw new CustomException(DATABASE_ERROR);
  }

  @Override
  public MyInfoResponseDTO getMyInfo(Integer memberId) {
    Optional<Member> optional_member = memberMapper.findByMemberId(memberId);
    optional_member.orElseThrow(() -> new CustomException(INVALID_MEMBER_ID));

    Member member = optional_member.get();
    return MyInfoResponseDTO.builder()
            .memberId(memberId)
            .username(member.getUsername())
            .selected_cnt(member.getSelectedCnt())
            .build();
  }

  @Override
  @Transactional
  public List<MySubmissionResponseDTO> getAllMySubmissions(Integer memberId, String filtering) {
    List<Submission> result = filtering.equals("ongoing") ? memberMapper.findSubmissionsByMemberIdOngoing(memberId) : memberMapper.findSubmissionsByMemberIdEnded(memberId);
    log.info("MemberService Result: " + result);
    return result.stream().map(s -> MySubmissionResponseDTO.builder()
            .recommendCnt(s.getRecommendCnt())
            .submissionId(s.getSubmissionId())
            .isSelected(s.getIsSelected())
            .relayId(s.getRelayId())
            .build())
            .collect(Collectors.toList());
  }

  @Override
  @Transactional
  public void changePassword(Integer memberId, ChangePasswordDTO changePasswordDTO) {
    Optional<Member> optional_member = memberMapper.findByMemberId(memberId);

    if (optional_member.isEmpty()) {
      log.error("사용자를 찾지 못했습니다.");
      throw new CustomException(MEMBER_NOT_FOUND);
    }

    Member member = optional_member.get();
    /* matches 메서드 인자 순서 중요 (plain text, encoded text) */
    if (!passwordEncoder.matches(changePasswordDTO.getOldPassword(), member.getPassword())) {
      log.error("비밀번호가 일치하지 않습니다.");
      throw new CustomException(PASSWORD_NOT_MATCH);
    }

    if (!changePasswordDTO.getNewPassword().equals(changePasswordDTO.getPassword_validation())) {
      log.error("비밀번호 확인에 실패했습니다.");
      throw new CustomException(PASSWORD_VALIDATION_FAILED);
    }
    member.changePassword(passwordEncoder.encode(changePasswordDTO.getNewPassword()));
    if (memberMapper.changePassword(member) == 0) throw new CustomException(DATABASE_ERROR);
  }
}
