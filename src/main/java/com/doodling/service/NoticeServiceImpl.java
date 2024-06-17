package com.doodling.service;

import com.doodling.domain.NoticeVO;
import com.doodling.mapper.NoticeMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private NoticeMapper mapper;

    // 공지사항 등록
    @Override
    public void insertNotice(NoticeVO notice) throws Exception {
        try {
            log.info("insert notice -> " + notice);
            mapper.insertNotice(notice);
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw e;
        }
    }
}
