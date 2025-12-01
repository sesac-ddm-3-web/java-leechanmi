package org.example.simpleboard.infra.persistence.impl;


import java.util.Optional;

import org.example.simpleboard.domain.Comment;
import org.example.simpleboard.domain.Post;
import org.example.simpleboard.domain.repository.CommentRepository;
import org.example.simpleboard.infra.persistence.JpaCommentRepository;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {

    private final JpaCommentRepository jpaCommentRepository;

    @Override
    public Optional<Comment> findById(Long id) {
        return jpaCommentRepository.findById(id);
    }

    @Override
    public Comment save(Comment comment) {
        return jpaCommentRepository.save(comment);
    }

    @Override
    public void delete(Comment comment) {
        jpaCommentRepository.delete(comment);
    }

    @Override
    public void deleteAllByPostId(Long postId) {
        jpaCommentRepository.deleteByPostId(postId);
    }
}
