package com.example.agent_rnd.repository;

import com.example.agent_rnd.domain.proposal.Proposal;
import com.example.agent_rnd.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {

    List<Proposal> findByUserOrderByIdDesc(User user);
}