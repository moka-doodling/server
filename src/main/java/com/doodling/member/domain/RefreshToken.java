package com.doodling.member.domain;

import lombok.*;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RefreshToken {

  private Integer tokenId;
  private String refreshToken;
  private Integer memberId;
  private Date regdate;
  private Date expiredate;
}
