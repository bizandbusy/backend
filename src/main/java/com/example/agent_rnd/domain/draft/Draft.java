package com.example.agent_rnd.domain.draft;

import com.example.agent_rnd.domain.user.User;
import com.example.agent_rnd.domain.notice.ProjectNotice;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "drafts")
public class Draft {

    @Id
    @Column(name = "draft_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notice_id", nullable = false)
    private ProjectNotice projectNotice;

    @Column(name = "title")
    private String title;

    @Lob
    // [수정] columnDefinition = "LONGTEXT" 추가!
    @Column(name = "content", nullable = false, columnDefinition = "LONGTEXT")
    private String content;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}