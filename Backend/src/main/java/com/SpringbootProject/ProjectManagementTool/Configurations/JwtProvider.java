package com.SpringbootProject.ProjectManagementTool.Configurations;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.security.core.Authentication;


import javax.crypto.SecretKey;
import java.util.Date;

public class JwtProvider {
//    SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
//    String email = String.valueOf(claims.get("email"));
//    String authorities = String.valueOf(claims.get("authorities"));
    //    SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
//    SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());

        static SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
        public static String generateToken(Authentication authentication) {
            return Jwts.builder().setIssuedAt(new Date())
                    .setExpiration(new Date(new Date().getTime()+86400000L)) //Day 1
                    .claim("email",authentication.getName())
                    .signWith(key)
                    .compact();
        }

        public static String getEmailFromJwtToken(String jwt) {
                jwt=jwt.substring(7);
                Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();

                return String.valueOf(claims.get("email"));
        }


}
