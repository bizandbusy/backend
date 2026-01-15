package com.example.agent_rnd.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "NOTICE_PARSED_DATA")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class NoticeParsedData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parsed_id")
    private Long id;

    // [핵심] 공고 하나당 분석 데이터 하나 (1:1 관계)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id", nullable = false)
    private ProjectNotice projectNotice;

    // 필수 요건 (JSON 형태로 저장될 텍스트)
    @Lob
    @Column(name = "requirements_json", columnDefinition = "LONGTEXT")
    private String requirementsJson;

    // AI 작성 가이드
    @Lob
    @Column(name = "guide_text", columnDefinition = "LONGTEXT")
    private String guideText;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}