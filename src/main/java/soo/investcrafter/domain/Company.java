package soo.investcrafter.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import soo.investcrafter.dto.CashFlowStatementDto;
import soo.investcrafter.dto.IncomeStatementDto;

import java.util.List;

@Entity
@Getter
@Table(name = "company")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Company extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    private String name;

    @Column(length = 64)
    private String symbol;

    @Column(length = 64)
    private String industry;

    @Column(length = 16)
    private String exchange;

    @Column(length = 64)
    private String country;

    @OneToMany(mappedBy = "company")
    private List<KeyIndicator> keyIndicators;

    @OneToMany(mappedBy = "company")
    private List<BalanceSheet> balanceSheets;

    @OneToMany(mappedBy = "company")
    private List<IncomeStatement> incomeStatements;

    @OneToMany(mappedBy = "company")
    private List<CashFlowStatement> cashFlowStatements;

    //재무제표 업데이트 함수
    public void updateStatements(List<BalanceSheet> new_bs, List<IncomeStatement> new_income, List<CashFlowStatement> new_cf) {
        this.balanceSheets = new_bs;
        this.incomeStatements = new_income;
        this.cashFlowStatements = new_cf;
    }

}
