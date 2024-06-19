package com.doodling.notice.service;

import com.doodling.admin.dto.NoticeInsertRequestDTO;
import com.doodling.admin.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.model.InvalidTestClassError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.stream.IntStream;

@WebAppConfiguration // 모든 테스트에 어노테이션 추가
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:**/*-context.xml")
@Slf4j
public class NoticeServiceTests {

  /*

    private Integer noticeId;
    private String title;
    private String content;
   */
  @Autowired
  private NoticeService noticeService;

  @Test
  public void registerNotice() {
    IntStream.range(0, 100).forEach(i -> {
      noticeService.insertNotice(
              NoticeInsertRequestDTO.builder()
                      .title("공지사항" + i)
                      .content("content" + i)
                      .build());
    });
  }
}
