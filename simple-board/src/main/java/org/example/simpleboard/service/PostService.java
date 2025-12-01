package org.example.simpleboard.service;

import org.example.simpleboard.common.dto.PageInfoResDto;
import org.example.simpleboard.common.security.UnauthorizedException;
import org.example.simpleboard.controller.dto.PostDetailResDto;
import org.example.simpleboard.controller.dto.PostCreateReqDto;
import org.example.simpleboard.controller.dto.PostCreateResDto;
import org.example.simpleboard.controller.dto.PostSimpleResDto;
import org.example.simpleboard.controller.dto.PostsResDto;
import org.example.simpleboard.domain.Member;
import org.example.simpleboard.domain.Post;
import org.example.simpleboard.domain.repository.CommentRepository;
import org.example.simpleboard.domain.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class PostService {

    private final MemberService memberService;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public PostCreateResDto create(PostCreateReqDto dto, long memberId) {
        Member writer = memberService.getById(memberId);
        Post post = new Post(dto.title(), dto.content(), writer);
        Post created = postRepository.save(post);

        return new PostCreateResDto(created.getId());
    }

    public void delete(long postId, long deleterId) {
        Member deleter = memberService.getById(deleterId);
        Post post = findById(postId);

        if (!post.isWriter(deleter)) {
            throw new UnauthorizedException("삭제 권한이 없습니다.");
        }

        commentRepository.deleteAllByPostId(post.getId());
        postRepository.delete(post);
    }

    public PostDetailResDto getById(long id) {
        Post post = findById(id);
        post.hit();
        postRepository.save(post);
        return PostDetailResDto.toDto(post);
    }

    @Transactional(readOnly = true)
    public PostsResDto getPage(Pageable pageable) {
        Page<Post> posts = postRepository.findPage(pageable);

        return new PostsResDto(
            posts.getContent().stream()
                .map(PostSimpleResDto::toDto)
                .toList(),
            PageInfoResDto.from(posts)
        );
    }

    @Transactional(readOnly = true)
    public Post findById(long id) {
        return postRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("존재하지 않는 게시글 입니다."));
    }
}
