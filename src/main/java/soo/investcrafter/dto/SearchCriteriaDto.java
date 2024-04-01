package soo.investcrafter.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
public class SearchCriteriaDto {
    private Float minPeg;
    private Float maxPeg;
    private Float minDebtRatio;
    private Float maxDebtRatio;

    private Float minRoeRecent1yr;
    private Float maxRoeRecent1yr;
    private Float minRoeRecent2yr;
    private Float maxRoeRecent2yr;
    private Float minRoeRecent3yr;
    private Float maxRoeRecent3yr;

    private Float minOpmRecent1yr;
    private Float maxOpmRecent1yr;
    private Float minOpmRecent2yr;
    private Float maxOpmRecent2yr;
    private Float minOpmRecent3yr;
    private Float maxOpmRecent3yr;

    private Long minFreeCashFlow;
    private Long maxFreeCashFlow;
    private Float minDividendYield;
    private Float maxDividendYield;

    private Float minPbr;
    private Float maxPbr;
    private Float minPer;
    private Float maxPer;

    private Long minOperatingActivitiesCashFlow;
    private Long maxOperatingActivitiesCashFlow;
    private Long minInvestingActivitiesCashFlow;
    private Long maxInvestingActivitiesCashFlow;
    private Long minFinancingActivitiesCashFlow;
    private Long maxFinancingActivitiesCashFlow;
}
