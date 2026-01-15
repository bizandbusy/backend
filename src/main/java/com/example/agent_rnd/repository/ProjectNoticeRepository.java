package com.example.agent_rnd.repository;

import com.example.agent_rnd.domain.ProjectNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProjectNoticeRepository extends JpaRepository<ProjectNotice, Long> {

    // [기능] API 고유번호(seq)로 공고 찾기
    // 이미 있는 공고인지 중복 확인할 때 씁니다.
    Optional<ProjectNotice> findBySeq(String seq);
}