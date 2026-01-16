package com.example.agent_rnd.domain.notice;

import com.example.agent_rnd.domain.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "PROJECT_NOTICES")
public class ProjectNotice extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    private String agency; // 전담기관

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @Column(columnDefinition = "TEXT")
    private String url;

    @Enumerated(EnumType.STRING)
    private NoticeStatus status; // OPEN, CLOSED
}