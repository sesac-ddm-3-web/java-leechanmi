package org.example.simpleboard.service;

import org.example.simpleboard.controller.dto.CommentCreateReqDto;
import org.example.simpleboard.controller.dto.CommentCreateResDto;
import org.example.simpleboard.domain.Comment;
import org.example.simpleboard.domain.Member;
import org.example.simpleboard.domain.Post;
import org.example.simpleboard.domain.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class CommentService {

    private final PostService postService;
    private final MemberService memberService;
    private final CommentRepository commentRepository;

    public CommentCreateResDto create(CommentCreateReqDto dto, long writerId) {
        Post post = postService.findById(dto.postId());
        Member member = memberService.getById(writerId);
        Comment comment = new Comment(dto.content(), post, member);
        commentRepository.save(comment);

        return new CommentCreateResDto(post.getId());
    }

    public void delete(long id) {
        Comment comment = commentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("존재하지 않는 댓글입니다."));
        commentRepository.delete(comment);
    }
}
