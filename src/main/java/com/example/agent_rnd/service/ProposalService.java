package com.example.agent_rnd.service;

import com.example.agent_rnd.domain.proposal.Proposal;
import com.example.agent_rnd.domain.user.User;
import com.example.agent_rnd.repository.ProposalRepository;
import com.example.agent_rnd.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProposalService {

    private final ProposalRepository proposalRepository;
    private final UserRepository userRepository;

    // 1. 내 제안서 목록 조회
    public List<Proposal> getMyProposals(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        // [수정] CreatedAt -> Id 역순 정렬 호출
        return proposalRepository.findByUserOrderByIdDesc(user);
    }

    // 2. 제안서 상세 조회
    public Proposal getProposalDetail(Long proposalId) {
        return proposalRepository.findById(proposalId)
                .orElseThrow(() -> new IllegalArgumentException("제안서가 존재하지 않습니다."));
    }
}