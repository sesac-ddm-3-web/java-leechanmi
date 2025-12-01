package org.example.simpleboard.infra.persistence;

import org.example.simpleboard.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommentRepository extends JpaRepository<Comment, Long> {
    void deleteByPostId(Long postId);
}
