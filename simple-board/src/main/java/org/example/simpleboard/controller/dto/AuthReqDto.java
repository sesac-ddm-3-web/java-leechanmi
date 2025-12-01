package org.example.simpleboard.controller.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthReqDto(
    @NotBlank
    String username,
    @NotBlank
    String password
) {
}
