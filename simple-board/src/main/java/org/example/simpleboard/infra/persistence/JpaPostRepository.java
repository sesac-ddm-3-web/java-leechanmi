package org.example.simpleboard.infra.persistence;

import org.example.simpleboard.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPostRepository extends JpaRepository<Post, Long> {
}
