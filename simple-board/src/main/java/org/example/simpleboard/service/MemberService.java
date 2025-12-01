package org.example.simpleboard.service;

import org.example.simpleboard.controller.dto.MemberDetailResDto;
import org.example.simpleboard.domain.Member;
import org.example.simpleboard.domain.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 멤버 생성
    public Member createMember(String username, String password) {
        if (memberRepository.existsByUsername(username)) {
            throw new RuntimeException("이미 존재하는 username 입니다. 다른 이름으로 가입해주세요.");
        }

        Member member = new Member(username, password);
        return memberRepository.save(member);
    }

    // 멤버 조회
    @Transactional(readOnly = true)
    public MemberDetailResDto getMemberDetailById(Long memberId) {
        Member member = memberRepository.findById(memberId)
            .orElseThrow(() -> new RuntimeException("요청한 ID에 해당하는 멤버가 존재하지 않습니다."));

        return MemberDetailResDto.toDto(member);
    }

    // 멤버 조회
    @Transactional(readOnly = true)
    public Member getById(Long memberId) {
        return memberRepository.findById(memberId)
            .orElseThrow(() -> new RuntimeException("요청한 ID에 해당하는 멤버가 존재하지 않습니다."));
    }
}
