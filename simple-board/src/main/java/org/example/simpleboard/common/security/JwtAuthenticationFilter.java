package org.example.simpleboard.common.security;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter implements Filter {

    private final JwtService jwtService;

    @Override
    public void doFilter(
        ServletRequest servletRequest,
        ServletResponse servletResponse,
        FilterChain filterChain
    ) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("Authorization");

        try {
            if (token != null) {
                if (token.startsWith("Bearer")) {
                    token = token.replace("Bearer", "").strip();
                }

                Long memberId = jwtService.parseSubject(token);
                SecurityContextHolder.setMemberId(memberId);
            }
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            SecurityContextHolder.clear();
        }
    }
}
