package com.doodling.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class LoginResponseDTO {
  private String accessToken;
  private String refreshToken;
  private Integer memberId;
}
