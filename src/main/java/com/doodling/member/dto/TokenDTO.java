package com.doodling.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Builder
@ToString
public class TokenDTO {

  private String accessToken;
  private String refreshToken;
  private Date refreshTokenExpiredate;
}
