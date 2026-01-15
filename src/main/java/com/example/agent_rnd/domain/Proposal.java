package com.example.agent_rnd.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "PROPOSALS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proposal_id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    // [연결 1] 어떤 공고인지
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id", nullable = false)
    private ProjectNotice projectNotice;

    // [연결 2] 어떤 초안을 썼는지
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "draft_id", nullable = false)
    private Draft draft;

    // [연결 3] 어떤 양식(템플릿)을 썼는지 (일단 ID만 필드로 둠)
    @Column(name = "template_id")
    private Long templateId;

    @Column(nullable = false)
    private String title;

    // AI가 써준 내용
    @Lob
    @Column(name = "final_content", columnDefinition = "LONGTEXT")
    private String finalContent;

    // 최종 파일(hwp/docx) 경로
    @Column(name = "file_path", length = 500)
    private String filePath;

    // 상태 (GENERATING, COMPLETED 등)
    @Column(nullable = false)
    @Builder.Default
    private String status = "GENERATING";

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}