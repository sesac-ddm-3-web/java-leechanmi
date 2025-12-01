package org.example.simpleboard.infra.persistence.impl;

import java.util.Optional;

import org.example.simpleboard.domain.Member;
import org.example.simpleboard.domain.repository.MemberRepository;
import org.example.simpleboard.infra.persistence.JpaMemberRepository;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final JpaMemberRepository jpaMemberRepository;

    @Override
    public Member save(Member member) {
        return jpaMemberRepository.save(member);
    }

    @Override
    public Optional<Member> findById(Long Id) {
        return jpaMemberRepository.findById(Id);
    }

    @Override
    public Optional<Member> findByUsername(String username) {
        return jpaMemberRepository.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return jpaMemberRepository.existsByUsername(username);
    }
}
