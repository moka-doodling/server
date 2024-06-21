package com.doodling.member.mapper;

import java.util.List;
import java.util.Optional;

import com.doodling.global.dto.Criteria;
import com.doodling.member.domain.Member;
import com.doodling.member.domain.MySubmission;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
	
	Optional<Member> findByUsername(String username);
	Long countTotal();
	void insert(Member member);
	int deleteUserByMemberId(Integer memberId);
	Optional<Member> findByMemberId(Integer memberId);
	int changePassword(Member member);
	List<MySubmission> findSubmissionsByMemberId(@Param("memberId") Integer memberId, @Param("filtering") Integer filtering);
	int updateSelectedCnt(Integer memberId);
	int countMembersByUsername(String username);
	List<MySubmission> findSubmissionsByMemberIdPaging(@Param("cri") Criteria cri, @Param("memberId") Integer memberId, @Param("filtering") Integer filtering);
	int countTotalMySubmission(@Param("memberId") Integer memberId, @Param("filtering") Integer filtering);
}
