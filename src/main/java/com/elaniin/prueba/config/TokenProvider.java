/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elaniin.prueba.config;

import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author Jorgep503
 */
@Component
public class TokenProvider implements Serializable {

    //@Value("${jwt.secret}")
    private final String SIGNING_KEY = "myKeySecret";
    //@Value("${jwt.authorities-key}")
    private final String AUTHORITIES_KEY = "scopes";
    //@Value("${jwt.expiration}")
    private final long ACCESS_TOKEN_VALIDITY_SECONDS = 604800;

    public String getMailFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SIGNING_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(Authentication authentication) {
        final String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY, authorities)
                .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY_SECONDS * 1000))
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String mail = getMailFromToken(token);
        return (mail.equals(userDetails.getUsername())
                && !isTokenExpired(token));
    }

    public Boolean validateToken(String token) {
        return !isTokenExpired(token);
    }

    UsernamePasswordAuthenticationToken getAuthentication(final String token, final Authentication existingAuth, final UserDetails userDetails) {

        final JwtParser jwtParser = Jwts.parser().setSigningKey(SIGNING_KEY);
        final Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);
        final Claims claims = claimsJws.getBody();

        final Collection<? extends GrantedAuthority> authorities
                = Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
    }

    public String generateToken(String mail) {
        try {
            //Generate tokenJWT
            JwtBuilder tokenJWT = Jwts.builder()
                    .setSubject(mail)
                    .setExpiration(new Date(System.currentTimeMillis() + 900000))
                    .signWith(SignatureAlgorithm.HS512, SIGNING_KEY )
                    ;
            //Compact the tokenJWT + save the value in tokenJWTString
            String tokenJWTString = tokenJWT.compact();
            //Response to Request from Controller
            return tokenJWTString;

        } catch (Exception e) {
            return "Error creating the token JWT";
        }
    }
    
    public boolean validateTokenLink(String token){
        final JwtParser jwtParser = Jwts.parser().setSigningKey(SIGNING_KEY);
        final Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);
        final Claims claims = claimsJws.getBody();
        final Date expiration = claims.getExpiration();
        
        return expiration.before(new Date());
    }
}
