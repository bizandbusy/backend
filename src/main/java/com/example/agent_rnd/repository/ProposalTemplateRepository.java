package com.example.agent_rnd.repository;

import com.example.agent_rnd.domain.template.ProposalTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProposalTemplateRepository extends JpaRepository<ProposalTemplate, Long> {

    // 1. 파일명으로 정확히 찾기 (시스템 내부용)
    Optional<ProposalTemplate> findByFileName(String fileName);
}