package com.example.agent_rnd.domain.company;

import com.example.agent_rnd.domain.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "COMPANIES")
public class Company extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    @Column(name = "company_name", length = 100, nullable = false)
    private String name;

    @Column(name = "business_reg_no", length = 20, nullable = false)
    private String businessRegNo; // 사업자등록번호

    @Enumerated(EnumType.STRING)
    @Column(name = "contract_status", length = 20)
    private ContractStatus contractStatus; // ACTIVE, EXPIRED 등

    private LocalDateTime startDate; // 계약 시작일
    private LocalDateTime endDate;   // 계약 종료일
}