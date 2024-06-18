package com.doodling.member.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@ToString
public class Member {

	private Integer memberId;
	private String username;
	private String password;
	private String roles;
	private Integer selectedCnt;

	public List<String> getRoleList() {
		if (this.roles != null && this.roles.length() > 0) {
			return Arrays.asList(this.roles.split(","));
		}
		return new ArrayList();
	}

	public void changePassword(String password) {
		this.password = password;
	}
}
