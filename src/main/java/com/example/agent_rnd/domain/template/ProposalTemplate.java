package com.example.agent_rnd.domain.template;

import jakarta.persistence.*;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "PROPOSAL_TEMPLATES")
public class ProposalTemplate { // 상속(BaseTimeEntity)은 이미 제거된 상태여야 합니다.

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "template_id")
    private Long id;

    // [수정] DB의 file_name 컬럼과 매핑
    @Column(name = "file_name")
    private String fileName;

    // [수정] DB의 file_path 컬럼과 매핑
    @Column(name = "file_path")
    private String filePath;

    // [수정] DB의 structure_json 컬럼과 매핑
    @Column(name = "structure_json", columnDefinition = "JSON")
    private String structureJson;

    @OneToMany(mappedBy = "template", cascade = CascadeType.ALL)
    private List<TemplateQuestion> questions = new ArrayList<>();
}