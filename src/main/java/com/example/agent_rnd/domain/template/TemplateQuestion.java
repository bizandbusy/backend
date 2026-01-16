package com.example.agent_rnd.domain.template;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "TEMPLATE_QUESTIONS")
public class TemplateQuestion {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id")
    private ProposalTemplate template;

    private Integer sectionNo; // 1, 2, 3...
    private String topic;      // "개발 동기"

    @Column(columnDefinition = "TEXT")
    private String content;    // 실제 질문 내용

    @Column(columnDefinition = "TEXT")
    private String guide;      // 작성 가이드
}