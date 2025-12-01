package org.example.simpleboard.common.dto;

import org.springframework.data.domain.Page;

public record PageInfoResDto<T>(
    int page,
    int size,
    long totalElements,
    int totalPages,
    boolean hasNext,
    boolean hasPrevious
) {
    public static <T> PageInfoResDto<T> from(Page<T> page) {
        return new PageInfoResDto<>(
            page.getNumber(),
            page.getSize(),
            page.getTotalElements(),
            page.getTotalPages(),
            page.hasNext(),
            page.hasPrevious()
        );
    }
}
