package org.example.simpleboard.domain.repository;

import java.util.Optional;

import org.example.simpleboard.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostRepository {

    Post save(Post post);

    Optional<Post> findById(Long id);

    Page<Post> findPage(Pageable pageable);

    void delete(Post post);
}
