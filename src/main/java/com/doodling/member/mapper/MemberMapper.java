package com.doodling.member.mapper;

import java.util.List;
import java.util.Optional;

import com.doodling.member.domain.Member;
import com.doodling.member.domain.MySubmission;
import com.doodling.submission.domain.Submission;

public interface MemberMapper {
	
	Optional<Member> findByUsername(String username);
	Long countTotal();
	void insert(Member member);
	int deleteUserByMemberId(Integer memberId);
	Optional<Member> findByMemberId(Integer memberId);
	int changePassword(Member member);
	List<MySubmission> findSubmissionsByMemberIdOngoing(Integer memberId);
	List<MySubmission> findSubmissionsByMemberIdEnded(Integer memberId);
	int updateSelectedCnt(Integer memberId);
}
