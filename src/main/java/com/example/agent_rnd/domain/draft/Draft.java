package com.example.agent_rnd.domain.draft;

import com.example.agent_rnd.domain.common.BaseTimeEntity;
import com.example.agent_rnd.domain.user.User;
import com.example.agent_rnd.domain.template.ProposalTemplate;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "DRAFTS")
public class Draft extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "draft_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // [핵심] 이 초안이 어떤 양식의 질문에 대한 답변인지 연결
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id")
    private ProposalTemplate template;

    @Column(columnDefinition = "JSON")
    private String contentJson; // { "q_1": "답변...", "q_2": "답변..." }
}