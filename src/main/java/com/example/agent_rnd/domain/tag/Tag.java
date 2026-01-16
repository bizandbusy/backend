package com.example.agent_rnd.domain.tag;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "TAGS")
public class Tag {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private TagCategory category; // REGION, SECTOR, BUSINESS

    @Column(length = 100)
    private String name; // "서울", "금융", "2026 예비창업패키지..."
}