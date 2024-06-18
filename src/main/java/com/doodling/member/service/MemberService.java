package com.doodling.member.service;


import com.doodling.member.dto.MyInfoResponseDTO;
import com.doodling.member.dto.ChangePasswordDTO;
import com.doodling.member.dto.LoginRequestDTO;

import com.doodling.member.dto.MySubmissionResponseDTO;
import com.doodling.member.dto.ReissueTokenDTO;
import com.doodling.member.dto.TokenDTO;

import java.util.List;

public interface MemberService {
  void register(LoginRequestDTO dto);
  TokenDTO reissueToken(ReissueTokenDTO reissueTokenDto);
  boolean deleteUser(Integer memberId);
  MyInfoResponseDTO getMyInfo(Integer memberId);

  List<MySubmissionResponseDTO> getAllMySubmissions(Integer memberId, String filtering);
  boolean changePassword(Integer memberId, ChangePasswordDTO changePasswordDTO);

}
