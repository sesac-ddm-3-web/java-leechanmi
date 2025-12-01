package org.example.simpleboard.controller;

import org.example.simpleboard.common.security.SecurityContextHolder;
import org.example.simpleboard.controller.dto.PostDetailResDto;
import org.example.simpleboard.controller.dto.PostsResDto;
import org.example.simpleboard.controller.dto.PostCreateReqDto;
import org.example.simpleboard.controller.dto.PostCreateResDto;
import org.example.simpleboard.service.PostService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    /**
     * 게시글 생성
     */
    @PostMapping
    public ResponseEntity<PostCreateResDto> create(
        @RequestBody PostCreateReqDto request
    ) {
        long memberId = SecurityContextHolder.getMemberId();
        PostCreateResDto response = postService.create(request, memberId);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * 게시글 목록 조회
     */
    @GetMapping
    public ResponseEntity<PostsResDto> getPosts(
        Pageable pageable
    ) {
        PostsResDto response = postService.getPage(pageable);
        return ResponseEntity.ok(response);
    }

    /**
     * 게시글 상세 조회
     */
    @GetMapping("/{id}")
    public ResponseEntity<PostDetailResDto> getPost(
        @PathVariable(name = "id") long postId
    ) {
        PostDetailResDto response = postService.getById(postId);
        return ResponseEntity.ok(response);
    }

    /**
     * 게시글 삭제
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
        @PathVariable(name = "id") long postId
    ) {
        long memberId = SecurityContextHolder.getMemberId();
        postService.delete(postId, memberId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
