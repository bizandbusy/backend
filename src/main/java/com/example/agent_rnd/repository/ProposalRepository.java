package com.example.agent_rnd.repository;

import com.example.agent_rnd.domain.proposal.Proposal;
import com.example.agent_rnd.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {
    // 특정 사용자가 작성한 제안서 목록 조회
    List<Proposal> findByUserOrderByCreatedAtDesc(User user);
}