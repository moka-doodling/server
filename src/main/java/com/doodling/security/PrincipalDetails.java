package com.doodling.security;

import java.util.ArrayList;
import java.util.Collection;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.doodling.member.domain.Member;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * spring security에서 사용되는 사용자 인터페이스(UserDetails)를 구현한 클래스
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
@RequiredArgsConstructor
@Getter
@ToString
public class PrincipalDetails implements UserDetails {

	/**
	 * 사용자 클래스
	 */
	private final Member member;

	/**
	 * 사용자의 권한 정보 반환
	 * @return
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList();
		member.getRoleList().forEach((role) -> {
			authorities.add(() -> role);
		});
		return authorities;
	}

	@Override
	public String getPassword() {
		return member.getPassword();
	}

	@Override
	public String getUsername() {
		return member.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
