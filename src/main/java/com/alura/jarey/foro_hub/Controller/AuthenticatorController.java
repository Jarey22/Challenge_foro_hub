package com.alura.jarey.foro_hub.Controller;

import com.alura.jarey.foro_hub.Domain.User.User;
import com.alura.jarey.foro_hub.Security.TokenService;
import com.alura.jarey.foro_hub.Service.SCAuthenticator;
import com.alura.jarey.foro_hub.Service.SCToken;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AuthenticatorController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity doLogin(@RequestBody @Valid SCAuthenticator scAuthetication){
        var authenticationToken = new UsernamePasswordAuthenticationToken(scAuthetication.username(), scAuthetication.password());
        var authentication = authenticationManager.authenticate(authenticationToken);

        var SCToken = tokenService.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new SCToken(SCToken));
    }
}
