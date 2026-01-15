package com.example.agent_rnd.controller;

import com.example.agent_rnd.domain.ProjectNotice;
import com.example.agent_rnd.service.ProjectNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 웹 요청을 받는 창구(Controller)를 표시
@RequestMapping("/api/notices") // 주소가 /api/notices로 시작하는 것을 처리
@RequiredArgsConstructor
public class ProjectNoticeController {

    private final ProjectNoticeService projectNoticeService;

    // 1. 공고 목록 조회
    // 요청: GET http://localhost:8080/api/notices
    @GetMapping
    public List<ProjectNotice> getNotices() {
        return projectNoticeService.getAllNotices();
    }

    // 2. 공고 상세 조회
    // 요청: GET http://localhost:8080/api/notices/1
    @GetMapping("/{id}")
    public ProjectNotice getNoticeDetail(@PathVariable Long id) {
        return projectNoticeService.getNoticeDetail(id);
    }

    // 3. (테스트용) 공고 강제 저장/업데이트
    // 요청: POST http://localhost:8080/api/notices
    // 나중에 크롤러가 이 주소로 데이터를 쏘게 됨
    @PostMapping
    public Long saveNotice(@RequestBody ProjectNotice notice) {
        return projectNoticeService.saveNotice(notice);
    }
}