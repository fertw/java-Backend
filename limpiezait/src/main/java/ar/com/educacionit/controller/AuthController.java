package ar.com.educacionit.controller;

import ar.com.educacionit.security.JwtService;
import ar.com.educacionit.LoginRequest;
import ar.com.educacionit.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authManager, JwtService jwtService) {
        this.authManager = authManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest req) {
        Authentication auth = authManager.authenticate(
            new UsernamePasswordAuthenticationToken(req.username(), req.password())
        );
        var roles = auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        String token = jwtService.generateToken(auth.getName(), roles);
        long expires = 60 * 60; // segundos (debe coincidir con tu expiración configurada)
        return ResponseEntity.ok(new LoginResponse(token, expires));
    }
}
