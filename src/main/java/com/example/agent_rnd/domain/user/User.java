package com.example.agent_rnd.domain.user;

import com.example.agent_rnd.domain.common.BaseTimeEntity;
import com.example.agent_rnd.domain.company.Company;
import com.example.agent_rnd.domain.plan.Plan;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "USERS")
public class User extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    // [FK] 회사 정보
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    // [FK] 요금제 정보
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", nullable = false)
    private Plan plan;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private UserRole role; // ADMIN, MEMBER

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private UserStatus status; // ACTIVE, INACTIVE

    @Column(name = "is_free_used")
    private Boolean isFreeUsed;
}