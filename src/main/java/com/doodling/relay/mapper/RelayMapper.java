package com.doodling.relay.mapper;

import com.doodling.relay.domain.Book;
import com.doodling.relay.domain.Criteria;
import com.doodling.relay.domain.Relay;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RelayMapper {

    List<Relay> selectAllBookRelays();
  
    List<Relay> selectAllOngoingRelays(Integer filter);
  
    List<Book> selectBookDetailsByRelayId(@Param("relayId") Integer relayId);

    List<Relay> selectBookPaging(Criteria criteria);

    Integer countTotalBooks();
}
