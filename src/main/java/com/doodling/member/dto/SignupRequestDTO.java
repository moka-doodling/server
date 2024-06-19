package com.doodling.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class SignupRequestDTO {

  private String username;
  private String password;
  private String passwordValidation;
}
