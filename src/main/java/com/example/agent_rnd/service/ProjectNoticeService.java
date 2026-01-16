package com.example.agent_rnd.service;

import com.example.agent_rnd.domain.notice.NoticeStatus;
import com.example.agent_rnd.domain.notice.ProjectNotice;
import com.example.agent_rnd.repository.ProjectNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // 읽기 전용 (성능 최적화)
@RequiredArgsConstructor        // 생성자 주입 (Repository 연결)
public class ProjectNoticeService {

    private final ProjectNoticeRepository projectNoticeRepository;

    // 1. 모집 중인 공고 전체 조회
    public List<ProjectNotice> getOpenNotices() {
        return projectNoticeRepository.findByStatusOrderByStartDateDesc(NoticeStatus.OPEN);
    }

    // 2. 공고 검색 (키워드) -> 아까 만든 기능 사용!
    public List<ProjectNotice> searchNotices(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return getOpenNotices(); // 검색어 없으면 전체 목록 반환
        }
        return projectNoticeRepository.findByTitleContaining(keyword);
    }

    // 3. 공고 상세 조회 (ID로 찾기)
    public ProjectNotice getNoticeDetail(Long noticeId) {
        return projectNoticeRepository.findById(noticeId)
                .orElseThrow(() -> new IllegalArgumentException("해당 공고를 찾을 수 없습니다. id=" + noticeId));
    }
}