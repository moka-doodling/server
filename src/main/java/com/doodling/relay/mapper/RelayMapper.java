package com.doodling.relay.mapper;

import com.doodling.global.dto.Criteria;
import com.doodling.relay.domain.Book;
import com.doodling.relay.domain.Relay;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RelayMapper {

    // 완성된 책(종료된 공모전) 리스트 조회
    List<Relay> selectAllBookRelays();

    // 진행중인 공모전 리스트 조회
    List<Relay> selectAllOngoingRelays(Integer filter);

    // 완성된 책(종료된 공모전) 상세 조회
    List<Book> selectBookDetailsByRelayId(@Param("relayId") Integer relayId);

    //  완성된 책(종료된 공모전) 페이징
    List<Relay> selectBookPaging(Criteria criteria);

    // 총 개수
    Integer countTotalBooks();

    // 연령대로 필터링한 완료된 책 총 개수
    Integer countTotalBooksFilteringAge(Integer age);
}
