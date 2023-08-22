package com.CRM.Backend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTGenerator {
    public String generateToken(Authentication authentication){
        String username = authentication.getName();
        Date currentDate =new Date();
        Date expireDate = new Date(currentDate.getTime()+ SecurityConstants.JWTexpiration);
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS256,SecurityConstants.JwtSecret)
                .compact();
        return  token;
    }
    public String getUsernameFromJwt(String toekn){
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.JwtSecret)
                .parseClaimsJws(toekn)
                .getBody();
        return claims.getSubject();

    }
    public boolean validetoken(String token){
        try{Jwts.parser().setSigningKey(SecurityConstants.JwtSecret).parseClaimsJws(token);
            return true;
        }
        catch(Exception ex){
        throw new AuthenticationCredentialsNotFoundException("jwt was expired or incorrect");
        }

    }

}
