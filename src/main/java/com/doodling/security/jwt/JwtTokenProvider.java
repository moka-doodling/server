package com.doodling.security.jwt;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.stream.Collectors;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.security.SecurityException;

import com.doodling.member.domain.Member;
import com.doodling.member.dto.TokenDTO;
import com.doodling.security.PrincipalDetails;

import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Component
@Slf4j
public class JwtTokenProvider implements InitializingBean {

  private static final String secret = "your-secure-secret-key-your-secure-secret-key-your-secure-secret-key";

  private static final String AUTHORITIES_KEY = "auth";
  private static final String PREFIX = "Bearer";
  private static long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24; // 1��
  private static long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24 * 2; // 2��

  private Key key;

  @Override
  public void afterPropertiesSet() throws Exception {
    byte[] encodedKey = Base64.getEncoder().encode(secret.getBytes());
    this.key = Keys.hmacShaKeyFor(encodedKey);
  }

  /**
   * Access Token 발급
   *
   * @param member
   * @return Access Token
   * 유효기간 : 3시간
   */
  public String generateAccessToken(Member member) {
    long now = new Date().getTime();

    return Jwts.builder()
            .setSubject(member.getUsername())
            .claim(AUTHORITIES_KEY, member.getRoles())
            .setExpiration(new Date(now + ACCESS_TOKEN_EXPIRE_TIME))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
  }

  /**
   * Refresh Token 발급
   *
   * @param member
   * @return Refresh Token
   * 유효기간 14일 (2주)
   */
  public String generateRefreshToken(Member member) {
    long now = new Date().getTime();

    return Jwts.builder()
            .setSubject(member.getUsername())
            .claim(AUTHORITIES_KEY, member.getRoles())
            .setExpiration(new Date(now + REFRESH_TOKEN_EXPIRE_TIME))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
  }

  public TokenDTO generateToken(Authentication authentication) {
	  log.info("[jwt token provider] generate token: " + authentication.getPrincipal());
    String authorities = authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(","));

    log.info("authentication: " + authentication.getName());

    String accessToken = generateAccessToken(((PrincipalDetails) authentication.getPrincipal()).getMember());
    String refreshToken = generateRefreshToken(((PrincipalDetails) authentication.getPrincipal()).getMember());

    log.info("accessToken: " + accessToken.toString());
    log.info("refreshToken: " + refreshToken.toString());

    return TokenDTO.builder()
            .accessToken(accessToken)
            .refreshToken(refreshToken)
            .build();
  }

  public Authentication getAuthentication(String accessToken) {

    Claims claims = parseClaims(accessToken);

//    if (claims.get(AUTHORITIES_KEY) == null) throw new CustomException(ErrorCode.INVALID_AUTH_TOKEN);

    PrincipalDetails principal = new PrincipalDetails(
            Member.builder()
                    .username(claims.getSubject())
                    .roles(claims.get(AUTHORITIES_KEY).toString())
                    .build()
    );

    return new UsernamePasswordAuthenticationToken(principal, "", principal.getAuthorities());
  }

  public boolean validateToken(String token) {
    try {

      Jwts.parserBuilder()
              .setSigningKey(key)
              .build()
              .parseClaimsJws(token);

      return true;
    } catch (SecurityException | MalformedJwtException e) {
      log.info("유효하지 않은 access 토큰입니다.");
    } catch (ExpiredJwtException e) {
      log.info("만료된 access 토큰입니다.");
    } catch (UnsupportedJwtException e) {
      log.info("지원되지 않는 access 토큰입니다.");
    } catch (IllegalArgumentException e) {
      log.info("잘못된 access 토큰입니다.");
    }
    return false;
  }

  public boolean validRefreshToken(String token) {
    if (token == null) {
      log.error("[JwtTokenProvider] Token값이 존재하지 않습니다.");
      throw new JwtException("Token값이 존재하지 않습니다.");
    }

    log.info("받은 Refresh 토큰:" + token);
    try {

      Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
      return true;

    } catch (ExpiredJwtException e) { // 만료된 refresh 토큰
      log.error("만료된 refresh 토큰입니다.");
      throw new JwtException("만료된 refresh 토큰으로, 로그아웃이 필요합니다.");
    } catch (JwtException e) {  // 그 외 발생한 에러
      log.error("refresh token 에러입니다.");
      throw new JwtException("refresh token 에러입니다.");
    }
  }

  private Claims parseClaims(String accessToken) {
    try {
      return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
    } catch (ExpiredJwtException e) {
      return e.getClaims();
    }
  }
}