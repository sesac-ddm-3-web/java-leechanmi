package org.example.simpleboard.domain.repository;

import java.util.Optional;

import org.example.simpleboard.domain.Comment;

public interface CommentRepository {

    Optional<Comment> findById(Long id);

    Comment save(Comment comment);

    void delete(Comment comment);

    void deleteAllByPostId(Long postId);
}
