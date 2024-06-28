package com.doodling.admin.service;

import com.doodling.admin.dto.NoticeInsertRequestDTO;
import com.doodling.admin.dto.NoticeResponseDTO;
import com.doodling.admin.dto.NoticeListResponseDTO;

import java.util.List;

public interface NoticeService {

    //공지사항 등록
    void insertNotice(NoticeInsertRequestDTO request);
    //공지사항 삭제
    boolean deleteNotice(Integer noticeId);
    //공지사항 상세 조회
    NoticeResponseDTO getNotice(Integer noticeId);
    //공지사항 전체 리스트 조회
    public List<NoticeListResponseDTO> getNoticeList();
}
