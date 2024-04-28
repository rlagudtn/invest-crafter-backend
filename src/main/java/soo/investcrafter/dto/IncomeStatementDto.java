package soo.investcrafter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import soo.investcrafter.domain.IncomeStatement;

@Data
@AllArgsConstructor
public class IncomeStatementDto {
    private Long id;
    private String calendarYear;
    private Long revenue;
    private Long researchAndDevelop;
    private Long operatingIncome;
    private Float opm;
    private Long netIncome;
    private Float eps;
    private String url;

    public IncomeStatementDto(IncomeStatement incomeStatement) {
        this.id = incomeStatement.getIncomeStatementId();
        this.calendarYear = incomeStatement.getCalendarYear();
        this.revenue = incomeStatement.getRevenue();
        this.researchAndDevelop = incomeStatement.getResearchAndDevelop();
        this.operatingIncome = incomeStatement.getOperatingIncome();
        this.opm = incomeStatement.getOpm();
        this.netIncome = incomeStatement.getNetIncome();
        this.eps = incomeStatement.getEps();
        this.url = incomeStatement.getUrl();
    }
}
