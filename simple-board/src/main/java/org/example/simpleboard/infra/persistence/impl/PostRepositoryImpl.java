package org.example.simpleboard.infra.persistence.impl;

import java.util.Optional;

import org.example.simpleboard.domain.Post;
import org.example.simpleboard.domain.repository.PostRepository;
import org.example.simpleboard.infra.persistence.JpaCommentRepository;
import org.example.simpleboard.infra.persistence.JpaPostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final JpaPostRepository jpaPostRepository;

    @Override
    public Post save(Post post) {
        return jpaPostRepository.save(post);
    }

    @Override
    public Optional<Post> findById(Long Id) {
        return jpaPostRepository.findById(Id);
    }

    @Override
    public Page<Post> findPage(Pageable pageable) {
        Pageable sorted = PageRequest.of(
            pageable.getPageNumber(),
            pageable.getPageSize(),
            Sort.by(Sort.Direction.DESC, "createdAt")
        );

        return jpaPostRepository.findAll(sorted);
    }

    @Override
    public void delete(Post post) {
        jpaPostRepository.delete(post);
    }
}
