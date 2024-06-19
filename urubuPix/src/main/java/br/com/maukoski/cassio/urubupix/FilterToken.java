package br.com.maukoski.cassio.urubupix;

import br.com.maukoski.cassio.urubupix.model.Error;
import br.com.maukoski.cassio.urubupix.repository.UsuarioRepository;
import br.com.maukoski.cassio.urubupix.service.TokenService;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@Component
public class FilterToken extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        String token;
        try {
            var authorizationHeader = request.getHeader("Authorization");
            if (authorizationHeader != null) {
                token = authorizationHeader.replace("Bearer ", "");

                var subject = this.tokenService.getSubject(token);
                var usuario = this.usuarioRepository.findByLogin(subject);
                if (usuario == null) {
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().print(new Error("token inválido!"));
                    response.getWriter().flush();
                    return;
                } else {

                    var authentication = new UsernamePasswordAuthenticationToken(usuario,
                            null, usuario.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);

                }


            } else if (!request.getRequestURI().equals("/usuario/login")) {
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().print(new Error("token vazio!"));
                response.getWriter().flush();
                return;
            }

        } catch (TokenExpiredException tokenExpiredException) {
            DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                    .appendPattern("dd/MM/yyyy HH:mm:ss")
                    .toFormatter()
                    .withZone(ZoneOffset.of("-03:00"));
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(new Error("token expirado em "+formatter.format(tokenExpiredException.getExpiredOn())+"!"));
            response.getWriter().flush();
            return;
        } catch (JWTDecodeException jwtDecodeException){
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(new Error("token inválido!"));
            response.getWriter().flush();
            return;
        }
        filterChain.doFilter(request, response);
    }


}