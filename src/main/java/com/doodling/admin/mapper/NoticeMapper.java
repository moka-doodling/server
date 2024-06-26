package com.doodling.admin.mapper;

import com.doodling.admin.domain.Notice;
import com.doodling.admin.dto.NoticeInsertRequestDTO;

import java.util.List;

public interface NoticeMapper {

    //공지사항 삽입
    void insertNotice(NoticeInsertRequestDTO request);
    //noticeId로 공지사항 삭제
    int deleteNotice(Integer noticeId);
    //noticeId로 공지사항 조회
    Notice getNotice(Integer noticeId);
    //공지사항 전체 리스트 조회
    List<Notice> getNoticeList();

}
