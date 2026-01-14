package com.example.agent_rnd.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "DRAFTS")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Draft {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "draft_id")
    private Long id;

    // 누가 썼는지 (나중에 User 테이블 생기면 연결, 지금은 ID만)
    @Column(name = "user_id")
    private Long userId;

    // [핵심] 어떤 공고를 보고 썼는지 (N:1 관계)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id", nullable = false)
    private ProjectNotice projectNotice;

    // 사용자가 적은 내용
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String contentText;

    // 파일 업로드 했을 경우 경로
    @Column(name = "file_path", length = 500)
    private String filePath;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}