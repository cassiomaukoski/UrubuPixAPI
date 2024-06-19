package br.com.maukoski.cassio.urubupix.service;

import br.com.maukoski.cassio.urubupix.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    public String gerarToken(Usuario usuario) {
        return JWT.create()
                .withIssuer("UrubuPix")
                .withSubject(usuario.getLogin())
                .withClaim("login", usuario.getLogin())
                .withExpiresAt(LocalDateTime.now()
                        .plusMinutes(30)
                        .toInstant(ZoneOffset.of("-03:00"))
                ).sign(Algorithm.HMAC256("secreta"));
    }


    public String getSubject(String token) throws TokenExpiredException, JWTDecodeException {
        return JWT.require(Algorithm.HMAC256("secreta"))
                .withIssuer("UrubuPix")
                .build().verify(token).getSubject();

    }
}
