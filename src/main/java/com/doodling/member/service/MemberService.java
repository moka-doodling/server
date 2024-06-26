package com.doodling.member.service;


import com.doodling.member.dto.*;

import java.util.List;

public interface MemberService {
  /* 회원가입 */
  Integer register(SignupRequestDTO signupRequestDTO);
  /* refresh token 기반으로 access token 재발급 */
  TokenDTO reissueToken(ReissueTokenDTO reissueTokenDto);
  /* 회원 탈퇴 */
  void deleteUser(Integer memberId, String refreshToken);
  /* 내 정보 불러오기 */
  MyInfoResponseDTO getMyInfo(Integer memberId);
  /* 내 제출물 전체 조회 */
  List<MySubmissionResponseDTO> getAllMySubmissions(Integer memberId, String filtering);
  /* 비밀번호 변경 */
  void changePassword(Integer memberId, ChangePasswordDTO changePasswordDTO);
  /* 내 제출물 페이징 조회 */
  MySubmissionPageDTO getAllMySubmissionsPaging(Integer memberId, String filtering, Integer offset);
}
