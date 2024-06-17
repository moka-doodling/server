package com.doodling.mapper;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.doodling.domain.Member;

public interface MemberMapper {
	
	public Optional<Member> findByUsername(String username);
	public Long countTotal();
	public void insert(Member member);
}
