package com.doodling.admin.service;

import com.doodling.admin.dto.NoticeInsertRequestDTO;
import com.doodling.admin.mapper.NoticeMapper;
import com.doodling.exception.CustomException;
import com.doodling.exception.ErrorCode;
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
    public void insertNotice(NoticeInsertRequestDTO request) {
        log.info("insert notice -> " + request);
        mapper.insertNotice(request);
    }

    @Override
    public boolean deleteNotice(Integer noticeId) {
        log.info("delete notice -> " + noticeId);
        int result = mapper.deleteNotice(noticeId);

        if (result == 0) throw new CustomException(ErrorCode.FAIL_TO_DELETE);

        return result == 1;
    }
}
