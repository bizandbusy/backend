package com.example.agent_rnd.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "PROJECT_NOTICES")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ProjectNotice {

    // ===============================================
    // 1. PK (기본키)
    // ===============================================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private Long id;

    // ===============================================
    // 2. API 데이터
    // ===============================================

    // [필수] 고유번호 (변경 불가 - Identity)
    @Column(nullable = false, unique = true, length = 100)
    private String seq;

    // [필수] 제목
    @Column(nullable = false, length = 500)
    private String title;

    // [선택] 링크
    @Column(length = 1000)
    private String link;

    // [선택] 소관기관
    @Column(length = 100)
    private String author;

    // [선택] 수행기관
    @Column(name = "exc_instt_nm", length = 100)
    private String excInsttNm;

    // [선택] 내용
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String description;

    // [필수] 등록일
    @Column(name = "pub_date", length = 50, nullable = false)
    private String pubDate;

    // [선택] 신청기간
    @Column(name = "reqst_dt", length = 100)
    private String reqstDt;

    // [선택] 지원대상
    @Column(name = "trget_nm", length = 200)
    private String trgetNm;

    // [선택] 파일 경로
    @Column(name = "print_flpth_nm", length = 500)
    private String printFlpthNm;

    // [선택] 파일명
    @Column(name = "print_file_nm", length = 200)
    private String printFileNm;

    // [선택] 해시태그
    @Column(name = "hash_tags", length = 500)
    private String hashTags;

    // ===============================================
    // 3. 메타 데이터
    // ===============================================

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // ===============================================
    // 4. 비즈니스 로직 (데이터 수정용)
    // ===============================================

    // API에서 가져온 최신 데이터(newData)로 내 정보(this)를 업데이트하는 기능
    // ID(PK)와 SEQ(고유번호), CreatedAt(생성일)은 바뀌지 않습니다.
    public void updateNoticeInfo(ProjectNotice newData) {
        this.title = newData.getTitle();
        this.link = newData.getLink();
        this.author = newData.getAuthor();
        this.excInsttNm = newData.getExcInsttNm();
        this.description = newData.getDescription();
        this.pubDate = newData.getPubDate();
        this.reqstDt = newData.getReqstDt();
        this.trgetNm = newData.getTrgetNm();
        this.printFlpthNm = newData.getPrintFlpthNm();
        this.printFileNm = newData.getPrintFileNm();
        this.hashTags = newData.getHashTags();
    }
}