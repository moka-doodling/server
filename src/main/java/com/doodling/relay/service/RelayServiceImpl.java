package com.doodling.relay.service;

import com.doodling.relay.domain.Book;
import com.doodling.relay.domain.Criteria;
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

@Slf4j
@Service
@AllArgsConstructor
public class RelayServiceImpl implements RelayService {

  private final RelayMapper relayMapper;

  @Transactional
  @Override
  public List<RelayResponseDTO> getAllBookRelays() {
    List<Relay> result = relayMapper.selectAllBookRelays();
    log.info(result + "");
    return result.stream().map(relay -> RelayResponseDTO.builder().relayId(relay.getRelayId()).title(relay.getTitle()).cover(relay.getCover()).age(relay.getAge()).build()).collect(Collectors.toList());
  }

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

  @Override
  public BookPageDTO getBooksPaging(Integer offset) {
    Criteria criteria = Criteria.builder()
            .pageNum(offset)
            .pageSize(2)
            .build();
    List<RelayResponseDTO> books = relayMapper.selectBookPaging(criteria).stream()
            .map(relay -> RelayResponseDTO.builder()
                    .relayId(relay.getRelayId())
                    .title(relay.getTitle())
                    .cover(relay.getCover())
                    .age(relay.getAge())
                    .build())
            .collect(Collectors.toList());

    int total = relayMapper.countTotalBooks();
    return BookPageDTO.builder()
            .total(total)
            .books(books)
            .cri(criteria)
            .build();
  }
}
