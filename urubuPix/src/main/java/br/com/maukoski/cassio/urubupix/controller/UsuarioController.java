package br.com.maukoski.cassio.urubupix.controller;

import br.com.maukoski.cassio.urubupix.dto.Login;
import br.com.maukoski.cassio.urubupix.model.Error;
import br.com.maukoski.cassio.urubupix.model.ItemCompra;
import br.com.maukoski.cassio.urubupix.model.Sucess;
import br.com.maukoski.cassio.urubupix.model.Usuario;
import br.com.maukoski.cassio.urubupix.service.TokenService;
import br.com.maukoski.cassio.urubupix.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;



    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login login) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(login.login(),
                        login.password());
        Authentication authenticate = this.authenticationManager
                .authenticate(usernamePasswordAuthenticationToken);
        Usuario usuario = (Usuario) authenticate.getPrincipal();
        return ResponseEntity.ok(tokenService.gerarToken(usuario));
    }
}

