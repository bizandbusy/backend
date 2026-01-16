package com.example.agent_rnd.domain.tag;

import com.example.agent_rnd.domain.company.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "COMPANY_TAGS")
public class CompanyTag {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "map_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public CompanyTag(Company company, Tag tag) {
        this.company = company;
        this.tag = tag;
    }
}