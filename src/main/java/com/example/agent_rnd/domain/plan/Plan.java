package com.example.agent_rnd.domain.plan;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "PLANS")
public class Plan {

    @Id
    @Column(name = "plan_id")
    private Integer id; // PK가 INT 형이므로 Integer

    @Column(name = "plan_name", length = 50, nullable = false)
    private String planName;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "is_downloadbale") // SQL 컬럼명(오타) 유지 or DB수정 후 맞춤
    private Boolean isDownloadable;

    @Column(name = "preview_page")
    private Integer previewPageLimit;
}