package com.example.testtask.controller;

import com.example.testtask.dto.authenticationAuthorisation.JwtAuthenticationResponse;
import com.example.testtask.dto.authenticationAuthorisation.SignInRequest;
import com.example.testtask.dto.authenticationAuthorisation.SignUpRequest;
import com.example.testtask.service.AuthenticationService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody @Valid SignUpRequest request) {
        return authenticationService.signUp(request);
    }

    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignInRequest request, HttpServletResponse response) {
        JwtAuthenticationResponse authResponse = authenticationService.signIn(request);

        // Создаём HttpOnly куку с токеном
        ResponseCookie cookie = ResponseCookie.from("jwtToken", authResponse.getToken())
                .httpOnly(true)   // Защита от XSS
                .secure(true)     // Работает только по HTTPS
                .path("/")        // Кука доступна на всём сайте
                .maxAge(Duration.ofHours(1)) // Живёт 1 час
                .build();

        response.setHeader("Set-Cookie", cookie.toString());

        return ResponseEntity.ok(authResponse).getBody();
    }
}
