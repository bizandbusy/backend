package com.example.agent_rnd.repository;

import com.example.agent_rnd.domain.notice.NoticeStatus;
import com.example.agent_rnd.domain.notice.ProjectNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectNoticeRepository extends JpaRepository<ProjectNotice, Long> {

    // 1. "모집 중(OPEN)"인 공고만 최신순으로 조회
    List<ProjectNotice> findByStatusOrderByStartDateDesc(NoticeStatus status);

    // 2. 제목으로 공고 검색 (예: "AI", "데이터" 등)
    List<ProjectNotice> findByTitleContaining(String keyword);
}