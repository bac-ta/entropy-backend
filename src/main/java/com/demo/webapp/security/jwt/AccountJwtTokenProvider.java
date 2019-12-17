package com.demo.webapp.security.jwt;

import com.demo.webapp.constant.ExceptionMessage;
import com.demo.webapp.factory.JwtTokenProviderFactory;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import java.util.Date;

public class AccountJwtTokenProvider implements JwtTokenProviderFactory {

    private static final Logger logger = LoggerFactory.getLogger(AccountJwtTokenProvider.class);
    @Value("${admin.security.jwt.client-secret-key}")
    private String clientSecrectKey;
    @Value("${admin.security.jwt.expirationInMs}")
    private int expirationInMs;

    @Override
    public String generateToken(Authentication authentication) {
        AccountPrincipal principal = (AccountPrincipal) authentication.getPrincipal();
        Date dateNow = new Date();
        Date expiryDate = new Date(dateNow.getTime() + expirationInMs);
        String payload = new Gson().toJson(principal);
        return Jwts.builder().setSubject(principal.getId().toString()).setPayload(payload).setIssuedAt(dateNow).
                setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, clientSecrectKey).compact();
    }

    @Override
    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser().setSigningKey(clientSecrectKey).parseClaimsJws(token).getBody();
        return Long.valueOf(claims.getSubject());
    }

    @Override
    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(clientSecrectKey).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            logger.error(ExceptionMessage.INVALID_JWT_SIGNATURE);
        } catch (MalformedJwtException | IllegalArgumentException ex) {
            logger.error(ExceptionMessage.INVALID_JWT_TOKEN);
        } catch (ExpiredJwtException ex) {
            logger.error(ExceptionMessage.EXPIRED_JWT_TOKEN);
        } catch (UnsupportedJwtException ex) {
            logger.error(ExceptionMessage.UNSUPPORT_JWT_TOKEN);
        }
        return false;
    }
}
