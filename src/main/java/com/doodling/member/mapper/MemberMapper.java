package com.doodling.member.mapper;

import java.util.List;
import java.util.Optional;

import com.doodling.global.dto.Criteria;
import com.doodling.member.domain.Member;
import com.doodling.member.domain.MySubmission;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {

	// username(멤버 아이디)으로 멤버 조회
	Optional<Member> findByUsername(String username);
	// 전체 멤버 수 조회
	Long countTotal();
	// 멤버 삽입
	void insert(Member member);
	// 멤버 고유번호로 멤버 삭제
	int deleteUserByMemberId(Integer memberId);
	// memberId(멤버 고유번호)으로 멤버 조회
	Optional<Member> findByMemberId(Integer memberId);
	// 비밀번호 수정
	int changePassword(Member member);
	// 유저 정보로 제출물 조회
	List<MySubmission> findSubmissionsByMemberId(@Param("memberId") Integer memberId, @Param("filtering") Integer filtering);
	// 당선 횟수 업데이트
	int updateSelectedCnt(Integer memberId);
	// 당선 횟수 취소
	int cancelSelectedCnt(Integer memberId);
	// 중복 아이디 방지하기 위해 username(멤버 아이디)로 유저 수 찾아오기
	int countMembersByUsername(String username);
	// 내 제출물 페이징 조회
	List<MySubmission> findSubmissionsByMemberIdPaging(@Param("cri") Criteria cri, @Param("memberId") Integer memberId, @Param("filtering") Integer filtering);
	// 내 제출물 개수 조회
	int countTotalMySubmission(@Param("memberId") Integer memberId, @Param("filtering") Integer filtering);
}
