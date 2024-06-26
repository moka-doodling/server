package com.doodling.relay.service;

import com.doodling.global.dto.Criteria;
import com.doodling.relay.domain.Book;
import com.doodling.relay.domain.Relay;
import com.doodling.relay.dto.BookPageDTO;
import com.doodling.relay.dto.RelayDetailResponseDTO;
import com.doodling.relay.dto.RelayResponseDTO;
import com.doodling.relay.dto.SubmissionDetailDTO;
import com.doodling.relay.mapper.RelayMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 릴레이(공모전) 로직 구현
 *
 * @author 이주현
 * @since 2024.06.18
 * @version 1.0
 *
 * <pre>
 * 수정일       수정자    수정내용
 * ---------- -------- ---------------------
 * 2024.06.18 이주현    최초 생성
 * 2024.06.21 김지수    페이징 처리 추가
 * </pre>
 */

@Slf4j
@Service
@AllArgsConstructor
public class RelayServiceImpl implements RelayService {

  private final RelayMapper relayMapper;

  /**
   * 완성된 책(종료된 공모전) 리스트 조회
   * @return List<RelayResponseDTO>
   */
  @Transactional
  @Override
  public List<RelayResponseDTO> getAllBookRelays() {
    List<Relay> result = relayMapper.selectAllBookRelays();
    log.info(result + "");
    return result.stream().map(relay -> RelayResponseDTO.builder().relayId(relay.getRelayId()).title(relay.getTitle()).cover(relay.getCover()).age(relay.getAge()).build()).collect(Collectors.toList());
  }

  /**
   * 릴레이 전체 목록 조회
   * @param filtering
   * @return List<RelayResponseDTO>
   */
  @Override
  @Transactional
  public List<RelayResponseDTO> getAllRelays(String filtering) {
    List<Relay> relays;

    final int IS_END_ONGOING = 0;
    final int IS_END_ENDED = 1;

    if ("ongoing".equals(filtering)) {
      relays = relayMapper.selectAllOngoingRelays(IS_END_ONGOING);
    } else {
      relays = relayMapper.selectAllOngoingRelays(IS_END_ENDED);
    }

    return relays.stream()
            .map(relay -> RelayResponseDTO.builder()
                    .relayId(relay.getRelayId())
                    .title(relay.getTitle())
                    .cover(relay.getCover())
                    .age(relay.getAge())
                    .build())
            .collect(Collectors.toList());
  }

  /**
   * 완성된 책(종료된 공모전) 상세 조회
   * @param relayId
   * @return RelayDetailResponseDTO
   */
  @Transactional
  @Override
  public RelayDetailResponseDTO getBookRelayDetail(Integer relayId) {
    List<Book> books = relayMapper.selectBookDetailsByRelayId(relayId);
    Map<Integer, SubmissionDetailDTO> submissions = books.stream()
            .collect(Collectors.toMap(
                    Book::getWeek,
                    book -> SubmissionDetailDTO.builder()
                            .submissionId(book.getSubmissionId())
                            .username(book.getUsername())
                            .content(book.getContent())
                            .sketch(book.getSketch())
                            .build()
            ));

    return RelayDetailResponseDTO.builder()
            .relayId(relayId)
            .submissions(submissions)
            .build();
  }

  /**
   * 완성된 책(종료된 공모전) 페이징
   * @param offset
   * @param age
   * @return BookPageDTO
   */
  @Override
  public BookPageDTO getBooksPaging(Integer offset, Integer age) {
    Criteria criteria = Criteria.builder()
            .pageNum(offset)
            .pageSize(4)
            .type(age.toString())
            .build();
    List<RelayResponseDTO> books = relayMapper.selectBookPaging(criteria).stream()
            .map(relay -> RelayResponseDTO.builder()
                    .relayId(relay.getRelayId())
                    .title(relay.getTitle())
                    .cover(relay.getCover())
                    .age(relay.getAge())
                    .build())
            .collect(Collectors.toList());

    int total = relayMapper.countTotalBooksFilteringAge(age);
    return BookPageDTO.builder()
            .total(total)
            .books(books)
            .cri(criteria)
            .build();
  }
}
