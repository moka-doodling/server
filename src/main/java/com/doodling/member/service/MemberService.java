package com.doodling.member.service;

import com.doodling.member.domain.Member;
import com.doodling.member.dto.ReissueTokenDTO;
import com.doodling.member.dto.TokenDTO;

public interface MemberService {
  void register(Member member);
  TokenDTO reissueToken(ReissueTokenDTO reissueTokenDto);
  boolean deleteUser(Integer memberId);
}
