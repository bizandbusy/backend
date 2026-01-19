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
    @JoinColumn(name = "template_id") // DB 컬럼명 확인 완료
    private ProposalTemplate template;

    @Column(name = "section_no") // [수정] DB의 section_no와 매핑
    private Integer sectionNo;

    private String topic;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "TEXT")
    private String guide;
}