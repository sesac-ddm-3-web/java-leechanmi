package org.example.simpleboard.service;

import org.example.simpleboard.domain.Member;
import org.example.simpleboard.domain.repository.MemberRepository;
import org.example.simpleboard.service.dto.LoginInfo;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    // 회원가입
    public LoginInfo signup(String username, String password) {
        Member created = memberService.createMember(username, password);
        return new LoginInfo(created.getId());
    }

    // 로그인
    public LoginInfo login(String username, String password) {
        Member member = memberRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("입력한 정보가 유효하지 않습니다."));

        if (!member.isPasswordMatch(password)) {
            throw new RuntimeException("입력하신 정보가 유효하지 않습니다.");
        }

        return new LoginInfo(member.getId());
    }
}
