package com.doodling.member.mapper;

import java.util.Optional;

import com.doodling.member.domain.Member;

public interface MemberMapper {
	
	Optional<Member> findByUsername(String username);
	Long countTotal();
	void insert(Member member);
	int deleteUserByMemberId(Integer memberId);
}
