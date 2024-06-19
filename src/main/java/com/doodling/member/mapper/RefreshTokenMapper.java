package com.doodling.member.mapper;

import com.doodling.member.domain.RefreshToken;

public interface RefreshTokenMapper {

  void insertRefreshToken(RefreshToken refreshToken);
  void insertExpiredRefreshToken(RefreshToken refreshToken);
  int delete(RefreshToken refreshToken);
  int deleteByMemberId(Integer memberId);
  int countMemberExpiredRefreshToken(RefreshToken refreshToken);
}
