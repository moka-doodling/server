package com.doodling.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Builder
@ToString
public class TokenDTO {

  private String accessToken;
  private String refreshToken;
}
