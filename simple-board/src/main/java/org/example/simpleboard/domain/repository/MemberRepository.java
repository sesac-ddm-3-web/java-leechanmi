package org.example.simpleboard.domain.repository;

import java.util.Optional;

import org.example.simpleboard.domain.Member;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findById(Long Id);

    Optional<Member> findByUsername(String username);

    boolean existsByUsername(String username);
}
