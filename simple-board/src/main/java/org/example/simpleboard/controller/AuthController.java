package org.example.simpleboard.controller;

import org.example.simpleboard.common.security.JwtService;
import org.example.simpleboard.controller.dto.AuthReqDto;
import org.example.simpleboard.controller.dto.AuthorizedTokenResDto;
import org.example.simpleboard.service.AuthService;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtService jwtService;

    /**
     * 회원가입
     */
    @PostMapping("/signup")
    public ResponseEntity<AuthorizedTokenResDto> signup(
        @RequestBody AuthReqDto request
    ) {
        Long memberId = authService.signup(request.username(), request.password()).userId();
        String accessToken = jwtService.createToken(memberId);

        return ResponseEntity.ok()
            .body(new AuthorizedTokenResDto(accessToken));

    }

    /**
     * 로그인
     */
    @PostMapping("/login")
    public ResponseEntity<AuthorizedTokenResDto> login(
        @RequestBody AuthReqDto request
    ) {
        System.out.println("야호");
        Long memberId = authService.login(request.username(), request.password()).userId();
        String accessToken = jwtService.createToken(memberId);

        return ResponseEntity.ok()
            .body(new AuthorizedTokenResDto(accessToken));
    }
}
