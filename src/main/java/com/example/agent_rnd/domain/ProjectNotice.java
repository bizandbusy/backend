package com.example.agent_rnd.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "PROJECT_NOTICES") // DB 테이블 이름
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ProjectNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private Long id;

    // --- 1. API 수집 데이터 (핵심) ---
    @Column(name = "api_seq", unique = true, length = 100)
    private String apiSeq; // 공고 고유 번호 (중복 방지)

    @Column(nullable = false, length = 500)
    private String title;

    @Lob // 내용이 기니까 LONGTEXT
    @Column(columnDefinition = "LONGTEXT")
    private String description; // 공고 본문

    @Column(length = 1000)
    private String noticeLink; // 원본 링크

    @Column(length = 100)
    private String author; // 소관 기관 (예: 중기부)

    @Column(name = "exec_agency", length = 100)
    private String execAgency; // 수행 기관

    @Column(name = "pub_date", length = 50)
    private String pubDate; // 등록일 (문자열)

    @Column(name = "reqst_period", length = 100)
    private String reqstPeriod; // 신청 기간

    @Column(name = "target_name", length = 200)
    private String targetName; // 지원 대상

    // --- 2. 첨부파일 정보 (API) ---
    @Column(name = "file_path", length = 500)
    private String filePath; // 공고문 다운로드 경로

    @Column(name = "file_name", length = 200)
    private String fileName; // 파일명

    @Column(length = 500)
    private String hashtags; // 해시태그

    // --- 3. 시스템 관리 ---
    @Column(name = "user_id")
    private Long userId; // 직접 등록한 경우 사용자 ID (API는 Null)

    @Column(nullable = false)
    @Builder.Default
    private String status = "OPEN"; // 상태 (OPEN/CLOSED)

    @Column(nullable = false)
    @Builder.Default
    private String category = "ETC"; // 카테고리

    @Column(name = "source_site")
    @Builder.Default
    private String sourceSite = "GOV_API"; // 출처 (API/User)

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}