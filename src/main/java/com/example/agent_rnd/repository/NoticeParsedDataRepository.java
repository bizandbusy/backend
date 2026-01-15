package com.example.agent_rnd.repository;

import com.example.agent_rnd.domain.NoticeParsedData;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface NoticeParsedDataRepository extends JpaRepository<NoticeParsedData, Long> {

    // [기능] 특정 공고(noticeId)의 분석 데이터 찾기 (1:1 관계)
    Optional<NoticeParsedData> findByProjectNoticeId(Long noticeId);
}