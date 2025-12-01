package org.example.simpleboard.controller;

import org.example.simpleboard.common.security.SecurityContextHolder;
import org.example.simpleboard.controller.dto.CommentCreateReqDto;
import org.example.simpleboard.controller.dto.CommentCreateResDto;
import org.example.simpleboard.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    /**
     * 댓글 생성
     */
    @PostMapping
    public ResponseEntity<CommentCreateResDto> create(
        @RequestBody CommentCreateReqDto request
    ) {
        long memberId = SecurityContextHolder.getMemberId();
        CommentCreateResDto response = commentService.create(request, memberId);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * 댓글 삭제
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
        @PathVariable(name = "id") long postId
    ) {
        commentService.delete(postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
