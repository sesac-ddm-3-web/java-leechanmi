package org.example.simpleboard.controller;

import org.example.simpleboard.common.security.SecurityContextHolder;
import org.example.simpleboard.common.security.UnauthenticatedException;
import org.example.simpleboard.common.security.UnauthorizedException;
import org.example.simpleboard.controller.dto.MemberDetailResDto;
import org.example.simpleboard.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 멤버 상세 조회
     */
    @GetMapping("/{id}")
    public ResponseEntity<MemberDetailResDto> getMemberById(
        @PathVariable(name = "id") Long requestedMemberId
    ) {
        Long memberId = SecurityContextHolder.getMemberId();

        if (!memberId.equals(requestedMemberId)) {
            throw new UnauthorizedException("해당 리소스에 접근 권한이 없습니다.");
        }

        MemberDetailResDto response = memberService.getMemberDetailById(requestedMemberId);
        return ResponseEntity.ok(response);
    }
}
