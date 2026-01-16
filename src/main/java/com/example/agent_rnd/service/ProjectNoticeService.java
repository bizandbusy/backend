package com.example.agent_rnd.service;

import com.example.agent_rnd.domain.notice.ProjectNotice;
import com.example.agent_rnd.repository.ProjectNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProjectNoticeService {

    private final ProjectNoticeRepository projectNoticeRepository;

    // 1. 모집 중인 공고 전체 조회
    public List<ProjectNotice> getOpenNotices() {
        // [수정] 리포지토리 메소드 변경 반영 (findByStatus... -> findAllBy...)
        return projectNoticeRepository.findAllByOrderByPubDateDesc();
    }

    // 2. 공고 검색
    public List<ProjectNotice> searchNotices(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return getOpenNotices();
        }
        return projectNoticeRepository.findByTitleContaining(keyword);
    }

    // 3. 공고 상세 조회
    public ProjectNotice getNoticeDetail(Long noticeId) {
        return projectNoticeRepository.findById(noticeId)
                .orElseThrow(() -> new IllegalArgumentException("해당 공고가 존재하지 않습니다. id=" + noticeId));
    }
}