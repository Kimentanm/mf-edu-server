package com.mf.security.jwt;

import com.mf.security.AuthenticatedUser;
import com.mf.service.UserService;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class TokenProvider {

    private final Logger log = LoggerFactory.getLogger(TokenProvider.class);

    private static final String AUTHORITIES_KEY = "auth";
    private static final String USER_ID = "user_id";
    private static final String USER_TYPE = "user_type";

    private String secretKey;

    private long tokenValidityInMilliseconds;

    private long tokenValidityInMillisecondsForRememberMe;

    @Autowired
    private UserService userService;

    @Autowired
    RedisTemplate redisTemplate;


    @PostConstruct
    public void init() {
        this.secretKey = "THNG12FFDKDFK233";

        this.tokenValidityInMilliseconds = 1000 * 2592000L;
        this.tokenValidityInMillisecondsForRememberMe = 1000 * 2592000L;
    }

    public String createToken(Authentication authentication, Boolean rememberMe, String userType) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        long now = (new Date()).getTime();
        Date validity;
        if (rememberMe) {
            validity = new Date(now + this.tokenValidityInMillisecondsForRememberMe);
        } else {
            validity = new Date(now + this.tokenValidityInMilliseconds);
        }

        Long tenantId = null;
        Long userId = null;
        if (authentication.getPrincipal() instanceof AuthenticatedUser) {
            AuthenticatedUser authenticatedUser = (AuthenticatedUser) authentication.getPrincipal();
            tenantId = authenticatedUser.getTenantId();
            userId = authenticatedUser.getUserId();
        }

        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY, authorities)
                .claim(USER_ID, userId)
                .claim(USER_TYPE, userType)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .setExpiration(validity)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        Long userId = null;
        if (claims.get(USER_ID) != null) {
            userId = Long.parseLong(claims.get(USER_ID).toString());
        }

        String userType = null;
        if (claims.get(USER_TYPE) != null) {
            userType = claims.get(USER_TYPE).toString();
        }

        AuthenticatedUser principal = new AuthenticatedUser(claims.getSubject(), "", authorities);
        principal.setUserId(userId);
        principal.setUserType(userType);

        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    public boolean validateToken(String authToken) {
        try {
            Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken).getBody();
            if (claims.get(USER_ID) != null) {
                return true;
            }
        } catch (SignatureException e) {
            log.info("Invalid JWT signature.");
            log.trace("Invalid JWT signature trace: {}", e);
        } catch (MalformedJwtException e) {
            log.info("Invalid JWT token.");
            log.trace("Invalid JWT token trace: {}", e);
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT token.");
            log.trace("Expired JWT token trace: {}", e);
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT token.");
            log.trace("Unsupported JWT token trace: {}", e);
        } catch (IllegalArgumentException e) {
            log.info("JWT token compact of handler are invalid.");
            log.trace("JWT token compact of handler are invalid trace: {}", e);
        }
        return false;
    }


    public boolean validateTokenInvalid(String authToken) {
        // ??????redis???????????????????????????token?????????????????????????????????????????????false
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken).getBody();
        String redisKey = claims.get(USER_TYPE).toString() + "-" + claims.get(USER_ID).toString();
        String redisToken = (String) redisTemplate.opsForValue().get(redisKey);
        return authToken.equals(redisToken);
    }
}
