package com.doodling.service;

import com.doodling.domain.Member;
import com.doodling.dto.ReissueTokenDTO;
import com.doodling.dto.TokenDTO;

public interface MemberService {
  void register(Member member);
  TokenDTO reissueToken(ReissueTokenDTO reissueTokenDto);
}
