package com.doodling.member.mapper;

import java.util.List;
import java.util.Optional;

import com.doodling.member.domain.Member;
import com.doodling.submission.domain.Submission;

public interface MemberMapper {
	
	Optional<Member> findByUsername(String username);
	Long countTotal();
	void insert(Member member);
	int deleteUserByMemberId(Integer memberId);
	Optional<Member> findByMemberId(Integer memberId);
	int changePassword(Member member);
	List<Submission> findSubmissionsByMemberIdOngoing(Integer memberId);
	List<Submission> findSubmissionsByMemberIdEnded(Integer memberId);
}
