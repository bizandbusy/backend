package com.example.agent_rnd.domain.template;

import com.example.agent_rnd.domain.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "PROPOSAL_TEMPLATES")
public class ProposalTemplate extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "template_id")
    private Long id;

    private String fileName;
    private String filePath; // S3 URL

    @Column(columnDefinition = "JSON")
    private String structureJson; // 파싱된 전체 구조

    // 양식 하나에 질문 여러 개 (1:N)
    @OneToMany(mappedBy = "template", cascade = CascadeType.ALL)
    private List<TemplateQuestion> questions = new ArrayList<>();
}