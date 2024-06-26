package com.doodling.admin.service;

import com.doodling.admin.domain.Notice;
import com.doodling.admin.dto.NoticeInsertRequestDTO;

import com.doodling.admin.dto.NoticeResponseDTO;

import com.doodling.admin.dto.NoticeListResponseDTO;

import com.doodling.admin.mapper.NoticeMapper;
import com.doodling.exception.CustomException;
import com.doodling.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 공지사항 도메인
 *
 * @author 김지현
 * @since 2024.06.19
 * @version 1.0
 *
 * <pre>
 * 수정일          수정자         내용
 * ------------- ----------- ---------------------------------
 * 2024.06.19    김지현       최초 생성
 * </pre>
 */
@Slf4j
@Service
@AllArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeMapper mapper;

    /**
     * 공지사항 등록
     * @param request
     */
    @Override
    public void insertNotice(NoticeInsertRequestDTO request) {
        log.info("insert notice -> " + request);
        mapper.insertNotice(request);
    }

    /**
     * 공지사항 삭제
     * @param noticeId
     * @return 삭제 성공 여부
     */
    @Override
    public boolean deleteNotice(Integer noticeId) {
        log.info("delete notice -> " + noticeId);
        int result = mapper.deleteNotice(noticeId);

        if (result == 0) throw new CustomException(ErrorCode.FAIL_TO_DELETE);

        return result == 1;
    }

    /**
     * 공지사항 상세조회
     * @param noticeId
     * @return NoticeResponseDTO
     */
    @Override
    public NoticeResponseDTO getNotice(Integer noticeId) {
        Notice notice = mapper.getNotice(noticeId);

        return NoticeResponseDTO.builder()
                .title(notice.getTitle())
                .content(notice.getContent())
                .regdate(notice.getRegdate())
                .build();
    }

    /**
     * 공지사항 전체 리스트 조회
     * @return List<NoticeListResponseDTO>
     */
    @Override
    public List<NoticeListResponseDTO> getNoticeList() {
        List<Notice> result = mapper.getNoticeList();

        return result.stream()
                .map(notice -> NoticeListResponseDTO.builder()
                        .noticeId(notice.getNoticeId())
                        .title(notice.getTitle())
                        .content(notice.getContent())
                        .regdate(notice.getRegdate())
                        .build())
                .collect(Collectors.toList());
    }
}
