package org.example.simpleboard.controller.dto;

import jakarta.validation.constraints.NotNull;

public record CommentCreateResDto(
    @NotNull
    Long postId
) {
}
