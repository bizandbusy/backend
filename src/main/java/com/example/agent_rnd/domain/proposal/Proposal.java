package com.example.agent_rnd.domain.proposal;

import com.example.agent_rnd.domain.user.User;
import com.example.agent_rnd.domain.draft.Draft;
import com.example.agent_rnd.domain.notice.ProjectNotice;
import com.example.agent_rnd.domain.template.ProposalTemplate;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "proposals")
public class Proposal {

    @Id
    @Column(name = "proposal_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "draft_id", nullable = false)
    private Draft draft;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id", nullable = false)
    private ProjectNotice projectNotice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id", nullable = false)
    private ProposalTemplate template;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(name = "final_content", nullable = false)
    private String finalContent;

    @Column(length = 20)
    private String version;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private ProposalStatus status;

    @Builder
    public Proposal(User user, Draft draft, ProjectNotice notice, ProposalTemplate template, String title, ProposalStatus status) {
        this.user = user;
        this.draft = draft;
        this.projectNotice = notice;
        this.template = template;
        this.title = title;
        this.status = status;
    }
}