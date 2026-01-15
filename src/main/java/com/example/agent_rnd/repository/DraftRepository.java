package com.example.agent_rnd.repository;

import com.example.agent_rnd.domain.Draft;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DraftRepository extends JpaRepository<Draft, Long> {

    // [기능] 특정 사용자(userId)가 쓴 초안 목록 다 가져오기
    List<Draft> findAllByUserId(Long userId);

    // [기능] 특정 공고(noticeId)에 달린 초안 다 가져오기
    List<Draft> findAllByProjectNoticeId(Long noticeId);
}