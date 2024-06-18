package com.doodling.mapper;

import com.doodling.domain.Notice;
import com.doodling.dto.NoticeInsertRequest;

public interface NoticeMapper {

    public void insertNotice(NoticeInsertRequest request);

}
