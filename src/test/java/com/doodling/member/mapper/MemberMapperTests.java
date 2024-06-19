package com.doodling.member.mapper;

import com.doodling.member.domain.Member;
import lombok.RequiredArgsConstructor;
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
public class MemberMapperTests {

  @Autowired
  private MemberMapper memberMapper;

  @Test
  public void insertMember() {
    IntStream.range(1, 100).forEach(i -> memberMapper.insert(
            Member.builder()
                    .username("user"+i)
                    .password("1234")
                    .roles("ROLE_USER")
                    .build()
    ));
  }

  @Test
  public void selectMember() {

  }
}
