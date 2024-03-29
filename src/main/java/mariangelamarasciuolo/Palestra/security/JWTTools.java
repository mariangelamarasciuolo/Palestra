package mariangelamarasciuolo.Palestra.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import mariangelamarasciuolo.Palestra.entities.Utente;
import mariangelamarasciuolo.Palestra.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTTools {
    @Value("${JWT_SECRET}")
    private String secret;


    public String createToken(Utente utente) {
        return Jwts.builder().setSubject(String.valueOf(utente.getId()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes())).compact();
    }

    public void verifyToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(secret.getBytes())).build().parse(token);
        } catch (Exception ex) {
            throw new UnauthorizedException("Invalid token, please log in.");
        }
    }

    public String extractIdFroToken(String token) {
        return Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(secret.getBytes())).build().parseClaimsJws(token).getBody().getSubject();
    }

    public Long getUserId(String token) {
        token = token.substring(7, token.length());
        String uId = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(secret.getBytes())).build().parseClaimsJws(token).getBody().getSubject();
        return Long.parseLong(uId);
    }
}

