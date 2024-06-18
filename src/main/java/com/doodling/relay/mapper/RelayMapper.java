package com.doodling.relay.mapper;

import com.doodling.relay.domain.Book;
import com.doodling.relay.domain.Relay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RelayMapper {

    List<Relay> selectAllBookRelays();
    List<Book> selectBookDetailsByRelayId(@Param("relayId") Integer relayId);

}
