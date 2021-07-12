package com.example.project.repository;

import com.example.project.domain.ConfToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfTokenRepository extends JpaRepository<ConfToken, Long> {

    Optional<ConfToken> findByToken(String token);
}
