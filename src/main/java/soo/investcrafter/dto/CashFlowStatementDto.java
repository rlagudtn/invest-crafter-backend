package soo.investcrafter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import soo.investcrafter.domain.CashFlowStatement;

@Data
@AllArgsConstructor
public class CashFlowStatementDto {
    private Long id;
    private String calendarYear;
    private Long operatingActivitiesCashFlow;
    private Long investingActivitiesCashFlow;
    private Long financingActivitiesCashFlow;
    private Long freeCashFlow;
    private Long dividendsPaid;
//    private Long totalEquity;
    private String url;

    public CashFlowStatementDto(CashFlowStatement cashFlowStatement) {
        this.id = cashFlowStatement.getId();
        this.calendarYear = cashFlowStatement.getCalendarYear();
        this.operatingActivitiesCashFlow = cashFlowStatement.getOperatingActivitiesCashFlow();
        this.investingActivitiesCashFlow = cashFlowStatement.getInvestingActivitiesCashFlow();
        this.financingActivitiesCashFlow = cashFlowStatement.getFinancingActivitiesCashFlow();
        this.freeCashFlow = cashFlowStatement.getFreeCashFlow();
        this.dividendsPaid = cashFlowStatement.getDividendsPaid();
//        this.totalEquity = cashFlowStatement.getTotalEquity();
        this.url = cashFlowStatement.getUrl();
    }
}
