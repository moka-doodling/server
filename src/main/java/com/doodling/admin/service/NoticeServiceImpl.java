package com.doodling.admin.service;

import com.doodling.admin.dto.NoticeInsertRequestDTO;
import com.doodling.admin.mapper.NoticeMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeMapper mapper;

    // 공지사항 등록
    @Override
    public void insertNotice(NoticeInsertRequestDTO request) throws Exception {
        try {
            log.info("insert notice -> " + request);
            mapper.insertNotice(request);
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw e;
        }
    }

    @Override
    public void deleteNotice(Integer noticeId) throws Exception {
        try {
            log.info("delete notice -> " + noticeId);
            mapper.deleteNotice(noticeId);
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw e;
        }
    }
}
