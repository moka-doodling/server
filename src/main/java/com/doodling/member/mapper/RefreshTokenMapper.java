package com.doodling.member.mapper;

import com.doodling.member.domain.RefreshToken;

public interface RefreshTokenMapper {

  // refresh token 삽입
  void insertExpiredRefreshToken(RefreshToken refreshToken);
  // 만약 멤버가 유효하지 않은 refresh token를 가지고 있는지 조회
  int countMemberExpiredRefreshToken(RefreshToken refreshToken);
}
