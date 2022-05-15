package com.team.three.gateway.jwt;

import com.team.three.gateway.domain.Member;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

import javax.crypto.SecretKey;
import java.util.HashMap;

public class TokenValidate {

    @Value("${jwt.secret}")
    private String secret;


    public Member getMemebrId(String token) {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
        Member member = new Member();

        try {
            member.setUserid(Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().get("userId").toString());
            member.setRole(Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().get("memberType").toString());
            member.setResult(0);
            return member;
        } catch (ExpiredJwtException e) {
            member.setResult(-1);
            return member;
        } catch (UnsupportedJwtException e) {
            member.setResult(-2);
            return member;
        } catch (Exception e) {
            member.setResult(-2);
            return member;
        }
    }
}
