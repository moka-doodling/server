package com.doodling.security;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.doodling.domain.Member;
import com.doodling.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Member> optional_member = memberMapper.findByUsername(username);
		log.info("[PrincipalDetailsService] loadUserByUsername {" + optional_member.get() + "}");
		log.info("principal details: " + new PrincipalDetails(optional_member.get()));

		
//		if (member_optional.isEmpty()) throw new Exception();

		return new PrincipalDetails(optional_member.get());
	}
}
