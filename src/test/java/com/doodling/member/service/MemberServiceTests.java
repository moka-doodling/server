package com.doodling.member.service;

import com.doodling.member.dto.LoginRequestDTO;
import com.doodling.member.dto.SignupRequestDTO;
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
public class MemberServiceTests {

  @Autowired
  public MemberService memberService;

  @Test
  public void registerTest() {
    IntStream.range(0, 100).forEach(i -> {
      memberService.register(
              SignupRequestDTO.builder()
                      .username("user"+i)
                      .password("123"+i)
                      .build());
    });
  }
}
