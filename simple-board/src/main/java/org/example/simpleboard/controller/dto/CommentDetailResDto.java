package org.example.simpleboard.controller.dto;

import java.time.LocalDateTime;

import org.example.simpleboard.domain.Comment;

public record CommentDetailResDto(
    long id,
    String content,
    LocalDateTime createdAt
) {

    public static CommentDetailResDto toDto(Comment comment) {
        return new CommentDetailResDto(
            comment.getId(),
            comment.getContent(),
            comment.getCreatedAt()
        );
    }
}
