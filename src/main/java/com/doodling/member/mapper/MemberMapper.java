package com.doodling.member.mapper;

import java.util.Optional;

import com.doodling.member.domain.Member;

public interface MemberMapper {
	
	public Optional<Member> findByUsername(String username);
	public Long countTotal();
	public void insert(Member member);
}
