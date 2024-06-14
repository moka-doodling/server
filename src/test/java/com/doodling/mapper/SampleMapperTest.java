package com.doodling.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.java.Log;

@WebAppConfiguration // 모든 테스트에 어노테이션 추가
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:**/*-context.xml") // -context.xml 로 끝나는 모든 파일 읽어들이기
@Log
public class SampleMapperTest {
	
	@Autowired
	private SampleMapper sampleMapper;
	
	@Test
	public void getTimeTest() {
		log.info(sampleMapper.getTime() + "");
	}
}
