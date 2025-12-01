package org.example.simpleboard.controller.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.example.simpleboard.domain.Post;

public record PostDetailResDto(
    Long id,
    String title,
    String content,
    String writerName,
    int hit,
    LocalDateTime createdAt,
    List<CommentDetailResDto> comments
    ) {

    public static PostDetailResDto toDto(Post post) {
        return new PostDetailResDto(
            post.getId(),
            post.getTitle(),
            post.getContent(),
            post.getWriter().getUsername(),
            post.getHit(),
            post.getCreatedAt(),
            post.getComments().stream()
                .map(CommentDetailResDto::toDto)
                .toList()
        );
    }
}
