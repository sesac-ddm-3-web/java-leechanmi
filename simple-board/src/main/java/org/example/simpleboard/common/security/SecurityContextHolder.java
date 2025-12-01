package org.example.simpleboard.common.security;

import java.util.Optional;

import javax.swing.text.html.Option;

public class SecurityContextHolder {

    private static final ThreadLocal<Long> memberIdHolder = new ThreadLocal<>();

    public static void setMemberId(Long memberId) {
        memberIdHolder.set(memberId);
    }

    public static long getMemberId() {
        return Optional.ofNullable(memberIdHolder.get())
            .orElseThrow(() -> new UnauthenticatedException("인증이 필요합니다."));
    }

    public static void clear() {
        memberIdHolder.remove();
    }
}
