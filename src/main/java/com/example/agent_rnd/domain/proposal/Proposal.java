package com.example.agent_rnd.domain.proposal;

import com.example.agent_rnd.domain.common.BaseTimeEntity;
import com.example.agent_rnd.domain.user.User;
import com.example.agent_rnd.domain.notice.ProjectNotice;
import com.example.agent_rnd.domain.template.ProposalTemplate;
import com.example.agent_rnd.domain.draft.Draft;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "PROPOSALS")
public class Proposal extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proposal_id")
    private Long id;

    // [User 직접 참조] 초안이 삭제되어도 제안서는 살아남음
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // [Draft 참조] 초안 없이 바로 생성할 수도 있으므로 Nullable
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "draft_id")
    private Draft draft;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id", nullable = false)
    private ProjectNotice projectNotice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id", nullable = false)
    private ProposalTemplate template;

    private String title;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String finalContent; // AI 생성 결과물

    @Enumerated(EnumType.STRING)
    private ProposalStatus status; // 작성중, 완료 등

    @Builder
    public Proposal(User user, Draft draft, ProjectNotice notice, ProposalTemplate template, String title) {
        this.user = user;
        this.draft = draft;
        this.projectNotice = notice;
        this.template = template;
        this.title = title;
        this.status = ProposalStatus.DRAFT;
    }
}