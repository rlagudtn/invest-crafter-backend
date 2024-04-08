package soo.investcrafter.domain;

import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Table(name = "income_statement")
@Getter
public class IncomeStatement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incomeStatementId;

    @Column(length = 8)
    private String calendarYear;

    private Long revenue;
    private Long researchAndDevelop;
    private Long operatingIncome;
    private Float opm;
    private Long netIncome;
    private Float eps;

    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    // Getters and Setters
}
