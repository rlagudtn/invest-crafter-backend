package soo.investcrafter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import soo.investcrafter.domain.KeyIndicator;

@Data
@AllArgsConstructor
public class KeyIndicatorDto {
    private Long id;
    private String calendarYear;
    private Float peg;
    private Float debtRatio;

    private Float roeRecent1yr;
    private Float roeRecent2yr;
    private Float roeRecent3yr;

    private Float opmRecent1yr;
    private Float opmRecent2yr;
    private Float opmRecent3yr;

    private Long freeCashFlow;
    private Float dividendYield;

    private Float pbr;
    private Float per;

    private Long operatingActivitiesCashFlow;
    private Long investingActivitiesCashFlow;
    private Long financingActivitiesCashFlow;

    public KeyIndicatorDto(KeyIndicator keyIndicator) {
        this.id = keyIndicator.getId();
        this.calendarYear = keyIndicator.getCalendarYear();
        this.peg = keyIndicator.getPeg();
        this.debtRatio = keyIndicator.getDebtRatio();

        this.roeRecent1yr = keyIndicator.getRoeRecent1yr();
        this.roeRecent2yr = keyIndicator.getRoeRecent2yr();
        this.roeRecent3yr = keyIndicator.getRoeRecent3yr();

        this.opmRecent1yr = keyIndicator.getOpmRecent1yr();
        this.opmRecent2yr = keyIndicator.getOpmRecent2yr();
        this.opmRecent3yr = keyIndicator.getOpmRecent3yr();

        this.freeCashFlow = keyIndicator.getFreeCashFlow();
        this.dividendYield = keyIndicator.getDividendYield();

        this.pbr = keyIndicator.getPbr();
        this.per = keyIndicator.getPer();

        this.operatingActivitiesCashFlow = keyIndicator.getOperatingActivitiesCashFlow();
        this.investingActivitiesCashFlow = keyIndicator.getInvestingActivitiesCashFlow();
        this.financingActivitiesCashFlow = keyIndicator.getFinancingActivitiesCashFlow();
    }
}
