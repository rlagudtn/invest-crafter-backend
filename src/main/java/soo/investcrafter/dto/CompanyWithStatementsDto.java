package soo.investcrafter.dto;

import soo.investcrafter.domain.Company;

import java.util.List;
import java.util.stream.Collectors;


public class CompanyWithStatementsDto extends CompanyDto{
    private List<BalanceSheetDto> balanceSheets;
    private List<IncomeStatementDto> incomeStatements;
    private List<CashFlowStatementDto> cashFlowStatements;

    public CompanyWithStatementsDto(Company company) {
        super(company);
        this.balanceSheets=company.getBalanceSheets()
                .stream()
                .map(balanceSheet -> new BalanceSheetDto(balanceSheet))
                .collect(Collectors.toList());

        this.incomeStatements=company.getIncomeStatements()
                .stream()
                .map(incomeStatement -> new IncomeStatementDto(incomeStatement))
                .collect(Collectors.toList());

        this.cashFlowStatements=company.getCashFlowStatements()
                .stream().map(cashFlowStatement -> new CashFlowStatementDto(cashFlowStatement))
                .collect(Collectors.toList());
    }


}
