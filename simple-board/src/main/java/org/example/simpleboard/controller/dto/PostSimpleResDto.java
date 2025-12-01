package org.example.simpleboard.controller.dto;

import java.time.LocalDateTime;

import org.example.simpleboard.domain.Post;

public record PostSimpleResDto(
    Long id,
    String title,
    String writerName,
    int hit,
    LocalDateTime createdAt
) {

    public static PostSimpleResDto toDto(Post post) {
        return new PostSimpleResDto(
            post.getId(),
            post.getTitle(),
            post.getWriter().getUsername(),
            post.getHit(),
            post.getCreatedAt()
        );
    }
}
