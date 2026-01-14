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
    // 2. 관리용 FK (수정됨: API 데이터일 수 있으므로 Null 허용!)
    // ===============================================
    @Column(name = "user_id", nullable = true)
    private Long userId;

    // ===============================================
    // 3. API 데이터 (물리명 snake_case 적용)
    // ===============================================

    // [필수] 고유번호는 꼭 있어야 함
    @Column(nullable = false, unique = true, length = 100)
    private String seq;

    // [필수] 제목 없는 공고는 없음
    @Column(nullable = false, length = 500)
    private String title;

    // [선택] 링크가 가끔 누락될 수 있음 -> Nullable
    @Column(length = 1000)
    private String link;

    // [선택] 소관기관
    @Column(length = 100)
    private String author;

    // [선택] 수행기관
    @Column(name = "exc_instt_nm", length = 100)
    private String excInsttNm;

    // [선택] 내용 (LongText)
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String description;

    // [필수] 등록일은 보통 있음
    @Column(name = "pub_date", length = 50, nullable = false)
    private String pubDate;

    // [선택] 신청기간 (상시 모집은 날짜가 없을 수 있음)
    @Column(name = "reqst_dt", length = 100)
    private String reqstDt;

    // [선택] 지원대상
    @Column(name = "trget_nm", length = 200)
    private String trgetNm;

    // [선택] 파일이 없는 공고도 많음! (N -> Y 필수)
    @Column(name = "print_flpth_nm", length = 500)
    private String printFlpthNm;

    // [선택] 파일명
    @Column(name = "print_file_nm", length = 200)
    private String printFileNm;

    // [선택] 해시태그 없을 수 있음
    @Column(name = "hash_tags", length = 500)
    private String hashTags;


    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}