package org.example.simpleboard.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CommentCreateReqDto(
    @NotNull
    Long postId,
    @NotBlank
    String content
) {
}
