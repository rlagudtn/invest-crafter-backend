package soo.investcrafter.domain;

import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Getter
@Table(name = "cash_flow_statement")
public class CashFlowStatement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cashflow_statement_id")
    private Long id;

    @Column(length = 8)
    private String calendarYear;

    private Long operatingActivitiesCashFlow;
    private Long investingActivitiesCashFlow;
    private Long financingActivitiesCashFlow;
    private Long freeCashFlow;
    private Long dividendsPaid;
    private Long totalEquity;

    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    // Getters and Setters
}
