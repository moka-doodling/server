package com.doodling.member.service;


import com.doodling.member.dto.*;

import java.util.List;

public interface MemberService {
  Integer register(SignupRequestDTO signupRequestDTO);
  TokenDTO reissueToken(ReissueTokenDTO reissueTokenDto);
  void deleteUser(Integer memberId, String refreshToken);
  MyInfoResponseDTO getMyInfo(Integer memberId);
  List<MySubmissionResponseDTO> getAllMySubmissions(Integer memberId, String filtering);
  void changePassword(Integer memberId, ChangePasswordDTO changePasswordDTO);

}
