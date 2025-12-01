package org.example.simpleboard.controller.dto;

import org.example.simpleboard.domain.Member;

public record MemberDetailResDto(
    Long memberId,
    String username
) {

    public static MemberDetailResDto toDto(Member member) {
        return new MemberDetailResDto(member.getId(), member.getUsername());
    }
}
