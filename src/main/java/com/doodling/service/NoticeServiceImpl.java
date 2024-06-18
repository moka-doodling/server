package com.doodling.service;

import com.doodling.domain.Notice;
import com.doodling.dto.NoticeInsertRequest;
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
    public void insertNotice(NoticeInsertRequest request) throws Exception {
        try {
            log.info("insert notice -> " + request);
            mapper.insertNotice(request);
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw e;
        }
    }
}
