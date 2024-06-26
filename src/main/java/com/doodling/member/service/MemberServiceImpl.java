package com.doodling.member.service;

import com.doodling.exception.CustomException;
import com.doodling.global.dto.Criteria;
import com.doodling.member.domain.Member;
import com.doodling.member.domain.MySubmission;
import com.doodling.member.domain.RefreshToken;
import com.doodling.member.dto.*;

import com.doodling.member.mapper.MemberMapper;
import com.doodling.member.mapper.RefreshTokenMapper;
import com.doodling.security.jwt.JwtTokenProvider;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.doodling.exception.ErrorCode.*;

/**
 * 회원 정보 도메인
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
public class MemberServiceImpl implements MemberService {

  private final BCryptPasswordEncoder passwordEncoder;

  private final MemberMapper memberMapper;
  private final RefreshTokenMapper refreshTokenMapper;
  private final JwtTokenProvider jwtTokenProvider;

  private final static String PREFIX = "Bearer ";

  /**
   * 회원 가입
   * @param request
   * @return Integer 멤버 고유번호
   */
  @Override
  @Transactional
  public Integer register(SignupRequestDTO signupRequestDTO) {

    if (0 < memberMapper.countMembersByUsername(signupRequestDTO.getUsername())) throw new CustomException(USERNAME_ALREADY_EXISTS);

    if (!signupRequestDTO.getPassword().equals(signupRequestDTO.getPasswordValidation()))
      throw new CustomException(PASSWORD_NOT_MATCH);

    Member member = Member.builder()
            .username(signupRequestDTO.getUsername())
            .password(passwordEncoder.encode(signupRequestDTO.getPassword()))
            .roles("ROLE_USER")
            .build();
    memberMapper.insert(member);

    return member.getMemberId();
  }

  /**
   * refresh token 기반으로 access token 새롭게 생성
   * @param request
   * @return access token
   */
  @Override
  @Transactional
  public TokenDTO reissueToken(ReissueTokenDTO reissueTokenDto) {
    log.info("reissueTokenDto: {}", reissueTokenDto);

    String refreshToken = reissueTokenDto.getRefreshToken();
    if (!(StringUtils.hasText(refreshToken) && refreshToken.startsWith("Bearer ")))
      throw new JwtException("유효하지 않은 refresh 토큰입니다.");

    // Bearer 와 같은 prefix를 제외한 순수한 Refresh token
    String pureRefreshToken = refreshToken.substring(7);

    boolean isValidRefreshToken = jwtTokenProvider.validRefreshToken(pureRefreshToken);

    if (!isValidRefreshToken) {
      log.error("유효하지 않은 refresh 토큰입니다.");
      throw new JwtException("유효하지 않은 refresh 토큰입니다.");
    }

    Optional<Member> optional_member = memberMapper.findByUsername(reissueTokenDto.getUsername());
    if (optional_member.isEmpty()) {
      log.error("member 정보를 찾을 수 없습니다.");
      throw new CustomException(MEMBER_NOT_FOUND);
    }
    // 만약 이미 expired_refresh_token 테이블에 같은 {member_id - refresh_token} 데이터가 들어가있다면 에러 반환
    log.info("[token reissue] memberId: {}, refreshToken: {}", optional_member.get().getMemberId(), pureRefreshToken);
    if (0 < refreshTokenMapper.countMemberExpiredRefreshToken(RefreshToken.builder()
            .memberId(optional_member.get().getMemberId())
            .refreshToken(pureRefreshToken)
            .build()))
      throw new CustomException(DUPLICATE_REFRESH_TOKEN);

    return TokenDTO.builder().accessToken(
                    PREFIX + jwtTokenProvider
                            .generateAccessToken(optional_member.get(), new Date().getTime()))
            .refreshToken(PREFIX + pureRefreshToken)
            .build();
  }

  /**
   * 회원 탈퇴
   * @param memberId
   * @param refreshToken
   */
  @Override
  @Transactional
  public void deleteUser(Integer memberId, String refreshToken) {
    if (memberMapper.deleteUserByMemberId(memberId) == 0) throw new CustomException(DATABASE_ERROR);

    if (!(StringUtils.hasText(refreshToken) && refreshToken.startsWith("Bearer ")))
      throw new JwtException("유효하지 않은 refresh 토큰입니다.");

    // Bearer 와 같은 prefix를 제외한 순수한 Refresh token
    String pureRefreshToken = refreshToken.substring(7);

    if (!jwtTokenProvider.validRefreshToken(pureRefreshToken)) {
      log.error("유효하지 않은 refresh 토큰입니다.");
      throw new JwtException("유효하지 않은 refresh 토큰입니다.");
    }

    // 회원탈퇴로 인해 사용할 수 없는, 기한이 남은 refresh token 을 expired_refresh_token 테이블에 삽입
    refreshTokenMapper.insertExpiredRefreshToken(
            RefreshToken.builder()
                    .refreshToken(pureRefreshToken)
                    .memberId(memberId)
                    .build()
    );
  }

  /**
   * 회원 정보 조회
   * @param memberId
   * @return MyInfoResponseDTO
   */
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

  /**
   * 내 제출물 전체 조회
   * @param memberId
   * @param filtering
   * @return List<MySubmissionResponseDTO> 내 제출물 목록
   */
  @Override
  @Transactional
  public List<MySubmissionResponseDTO> getAllMySubmissions(Integer memberId, String filtering) {
    List<MySubmission> result = memberMapper.findSubmissionsByMemberId(memberId, filtering.equals("ongoing") ? 0 : 1);
    log.info("MemberService Result: " + result);
    return result.stream().map(s ->
                    MySubmissionResponseDTO.builder()
                            .recommendCnt(s.getRecommendCnt())
                            .submissionId(s.getSubmissionId())
                            .isSelected(s.getIsSelected())
                            .relayId(s.getRelayId())
                            .sketch(s.getSketch())
                            .title(s.getTitle())
                            .regdate(s.getRegdate())
                            .build())
            .collect(Collectors.toList());
  }

  /**
   * 비밀번호 변경
   * @param memberId
   * @param changePasswordDTO
   */
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

    if (!changePasswordDTO.getNewPassword().equals(changePasswordDTO.getPasswordValidation())) {
      log.error("비밀번호 확인에 실패했습니다.");
      throw new CustomException(PASSWORD_VALIDATION_FAILED);
    }
    member.changePassword(passwordEncoder.encode(changePasswordDTO.getNewPassword()));
    if (memberMapper.changePassword(member) == 0) throw new CustomException(DATABASE_ERROR);
  }

  /**
   * 내 제출물 전체 조회 (페이징)
   * @param memberId
   * @param filtering
   * @param offset
   * @return List<MySubmissionResponseDTO> 내 제출물 목록 (페이징)
   */
  @Override
  public MySubmissionPageDTO getAllMySubmissionsPaging(Integer memberId, String filtering, Integer offset) {
    // 3개씩 나누어 조회
    Criteria criteria = Criteria.builder()
            .pageNum(offset)
            .pageSize(3)
            .build();
    List<MySubmissionResponseDTO> mySubmissions = memberMapper.findSubmissionsByMemberIdPaging(criteria, memberId, filtering.equals("ongoing") ? 0 : 1).stream().map(s ->
                    MySubmissionResponseDTO.builder()
                            .recommendCnt(s.getRecommendCnt())
                            .submissionId(s.getSubmissionId())
                            .isSelected(s.getIsSelected())
                            .relayId(s.getRelayId())
                            .sketch(s.getSketch())
                            .title(s.getTitle())
                            .regdate(s.getRegdate())
                            .build())
            .collect(Collectors.toList());
    log.info("MemberService Result: " + mySubmissions);

    int total = memberMapper.countTotalMySubmission(memberId, filtering.equals("ongoing") ? 0 : 1);
    return MySubmissionPageDTO.builder()
            .total(total)
            .mySubmissions(mySubmissions)
            .cri(criteria)
            .build();
  }
}
