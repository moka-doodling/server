package com.doodling.admin.service;

import com.doodling.admin.dto.NoticeInsertRequestDTO;
import com.doodling.admin.dto.NoticeListResponseDTO;

import java.util.List;

public interface NoticeService {

    public void insertNotice(NoticeInsertRequestDTO request);

    public boolean deleteNotice(Integer noticeId);

    public List<NoticeListResponseDTO> getNoticeList();
}
