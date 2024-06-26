package com.doodling.member.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 사용자 클래스
 *
 * @author 김지수
 * @since 2024.6.17
 * @version 1.0
 *
 * <pre>
 * 수정일        수정자        수정내용
 * ----------  --------    ---------------------------
 * 2024.6.17  김지수         최초 생성
 * </pre>
 */
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@ToString
public class Member {

	// 고유번호
	private Integer memberId;
	// 아이디
	private String username;
	// 비밀번호(encrypted)
	private String password;
	// 권한 목록(문자열)
	private String roles;
	// 당선된 횟수
	private Integer selectedCnt;

	// 유저의 역할(권한) 문자열에서 리스트 변환
	public List<String> getRoleList() {
		if (this.roles != null && this.roles.length() > 0) {
			return Arrays.asList(this.roles.split(","));
		}
		return new ArrayList();
	}

	// 비밀번호 변경
	public void changePassword(String password) {
		this.password = password;
	}
}
