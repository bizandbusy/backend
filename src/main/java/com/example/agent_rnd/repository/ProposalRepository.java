package com.example.agent_rnd.repository;

import com.example.agent_rnd.domain.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {

    // [기능] 특정 사용자(userId)의 제안서 목록 조회
    List<Proposal> findAllByUserId(Long userId);

    // [기능] 특정 초안(draftId)으로 만든 제안서 조회
    List<Proposal> findAllByDraftId(Long draftId);
}