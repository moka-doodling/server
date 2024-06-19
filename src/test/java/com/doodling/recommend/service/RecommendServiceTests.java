package com.doodling.recommend.service;

import com.doodling.recommend.dto.RecommendRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.stream.IntStream;

@WebAppConfiguration // 모든 테스트에 어노테이션 추가
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:**/*-context.xml")
@Slf4j
public class RecommendServiceTests {

  @Autowired
  public RecommendService recommendService;

  @Test
  public void registerRecomment() {
    IntStream.range(0, 100).forEach(i -> {
      recommendService.recommend(
              RecommendRequestDTO.builder()
                      .memberId(i + 1)
                      .submissionId((i + 2) % 100 + 1)
                      .build());
    });
  }
}
