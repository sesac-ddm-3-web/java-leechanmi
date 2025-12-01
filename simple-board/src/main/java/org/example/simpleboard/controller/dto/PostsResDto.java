package org.example.simpleboard.controller.dto;

import java.util.List;

import org.example.simpleboard.common.dto.PageInfoResDto;
import org.example.simpleboard.domain.Post;

public record PostsResDto(
    List<PostSimpleResDto> posts,
    PageInfoResDto<Post> pageInfo
) {
}
