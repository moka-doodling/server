package com.doodling.admin.service;

import com.doodling.admin.dto.NoticeInsertRequestDTO;
import com.doodling.admin.dto.NoticeResponseDTO;
import com.doodling.admin.dto.NoticeListResponseDTO;

import java.util.List;

public interface NoticeService {

    void insertNotice(NoticeInsertRequestDTO request);

    boolean deleteNotice(Integer noticeId);

    NoticeResponseDTO getNotice(Integer noticeId);

    public List<NoticeListResponseDTO> getNoticeList();
}
