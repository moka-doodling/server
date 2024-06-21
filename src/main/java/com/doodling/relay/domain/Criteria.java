package com.doodling.relay.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Criteria {

  private Integer pageSize;
  private Integer pageNum;

  private String type;
  private String keyword;

  public String getListLink() {
    return UriComponentsBuilder.fromPath("")
            .queryParam("pageNum", getPageNum())
            .queryParam("pageSize", getPageSize())
            .queryParam("type", getType())
            .queryParam("keyword", getKeyword()).toUriString();
  }

  public String[] getTypeArr() {
    return type == null ? new String[] {} : type.split("");
  }
}
