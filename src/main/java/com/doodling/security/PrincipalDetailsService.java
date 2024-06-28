package com.doodling.security;


import java.util.Optional;

import com.doodling.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.doodling.member.domain.Member;
import com.doodling.member.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

import static com.doodling.exception.ErrorCode.MEMBER_NOT_FOUND;

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
@Service
@Slf4j
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
	private MemberMapper memberMapper;

	/**
	 * 요청보낸 사용자가 유효한 사용자인지 확인
	 * @param username
	 *
	 * @return
	 * @throws UsernameNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Member> optional_member = memberMapper.findByUsername(username);
		log.info("[PrincipalDetailsService] loadUserByUsername {" + optional_member.get() + "}");
		log.info("principal details: " + new PrincipalDetails(optional_member.get()));

		if (optional_member.isEmpty()) throw new CustomException(MEMBER_NOT_FOUND);

		return new PrincipalDetails(optional_member.get());
	}
}
