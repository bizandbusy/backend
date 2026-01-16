package com.example.agent_rnd.repository;

import com.example.agent_rnd.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // 이메일로 회원 찾기 (로그인 시 필요)
    Optional<User> findByEmail(String email);

    // 이메일 중복 검사
    boolean existsByEmail(String email);
}