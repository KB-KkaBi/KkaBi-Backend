package com.project.jwt;



import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.project.domain.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class TokenProvider {// JWT토큰 생성 및 유효성을 검증하는 컴포넌트
	
	@Value("spring.jwt.secret")
    private String SECRET_KEY;
	private static final String AUTHORITIES_KEY = "auth";
	private static final String BEARER_TYPE = "bearer";
    private long tokenValidMilisecond = 1000L * 60 * 60; // 1시간만 토큰 유효
    
    
    @PostConstruct
    protected void init() {
    	SECRET_KEY = Base64.getEncoder().encodeToString(SECRET_KEY.getBytes());
    }
    
    // Jwt 토큰 생성
    public String createToken(String userPk, Collection<? extends GrantedAuthority> roles) {
      Claims claims = Jwts.claims().setSubject(userPk);
      Date now = new Date();
      
      String accessToken = Jwts.builder()
              .setClaims(claims) // 데이터
              .setIssuedAt(now) // 토큰 발행일자
              .setExpiration(new Date(now.getTime() + tokenValidMilisecond)) // set Expire Time
              .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // 암호화 알고리즘, secret값 세팅
              .compact();
      
      System.out.println(accessToken);
      
      return accessToken;
      
    }
    
    
 
}
