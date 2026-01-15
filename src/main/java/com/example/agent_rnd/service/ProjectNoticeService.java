package com.example.agent_rnd.service;

import com.example.agent_rnd.domain.ProjectNotice;
import com.example.agent_rnd.repository.ProjectNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProjectNoticeService {

    private final ProjectNoticeRepository projectNoticeRepository;

    // 1. 공고 전체 조회
    public List<ProjectNotice> getAllNotices() {
        return projectNoticeRepository.findAll();
    }

    // 2. 공고 상세 조회
    public ProjectNotice getNoticeDetail(Long noticeId) {
        return projectNoticeRepository.findById(noticeId)
                .orElseThrow(() -> new IllegalArgumentException("해당 공고를 찾을 수 없습니다. id=" + noticeId));
    }

    // 3. 공고 저장 또는 업데이트
    @Transactional // 쓰기 작업이므로 필수임
    public Long saveNotice(ProjectNotice notice) {
        // [단계 1] DB에 이미 같은 seq(고유번호)가 있는지 확인
        ProjectNotice existingNotice = projectNoticeRepository.findBySeq(notice.getSeq())
                .orElse(null);

        if (existingNotice != null) {
            // [단계 2-A] 이미 있다면? -> 업데이트 (Update)
            // updateNoticeInfo 메서드 사용
            existingNotice.updateNoticeInfo(notice);

            // 트랜잭션(@Transactional)이 끝날 때, 변경된 내용을 감지해서 자동으로 DB를 수정

            return existingNotice.getId();
        } else {
            // [단계 2-B] 없다면? -> "새로 저장 (Insert)"
            ProjectNotice savedNotice = projectNoticeRepository.save(notice);
            return savedNotice.getId();
        }
    }
}