package com.doodling.member.service;

import com.doodling.member.domain.Member;
import com.doodling.member.dto.ChangePasswordDTO;
import com.doodling.member.dto.LoginRequestDTO;
import com.doodling.member.dto.ReissueTokenDTO;
import com.doodling.member.dto.TokenDTO;

public interface MemberService {
  void register(LoginRequestDTO dto);
  TokenDTO reissueToken(ReissueTokenDTO reissueTokenDto);
  boolean deleteUser(Integer memberId);
  boolean changePassword(Integer memberId, ChangePasswordDTO changePasswordDTO);
}
