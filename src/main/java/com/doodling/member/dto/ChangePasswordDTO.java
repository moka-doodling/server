package com.doodling.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ChangePasswordDTO {

  private String oldPassword;
  private String newPassword;
  private String password_validation;
}
