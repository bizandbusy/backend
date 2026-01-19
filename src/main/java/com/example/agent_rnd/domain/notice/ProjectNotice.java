package com.example.agent_rnd.domain.notice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "project_notices")
public class ProjectNotice {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private Long id;

    @Column(name = "seq")
    private String seq;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "link", columnDefinition = "TEXT")
    private String url;

    @Column(name = "author")
    private String author;

    // [수정] DB의 컬럼명인 excInsttNm과 정확히 일치시킵니다.
    @Column(name = "excInsttNm")
    private String agency;

    @Lob
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;

    @Column(name = "pubDate")
    private String pubDate;

    // [수정] 다른 카멜케이스 컬럼들도 안전하게 name을 명시합니다.
    @Column(name = "reqstDt")
    private String requestPeriod;

    @Column(name = "trgetNm", columnDefinition = "TEXT")
    private String targetName;

    @Column(name = "printFlpthNm", columnDefinition = "TEXT")
    private String filePath;

    @Column(name = "printFileNm", columnDefinition = "TEXT")
    private String fileName;

    @Column(name = "hashTags", columnDefinition = "TEXT")
    private String hashTags;

    @Transient
    public String getStatus() { return "OPEN"; }
}