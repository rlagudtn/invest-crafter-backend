package soo.investcrafter.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "key_indicator")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class KeyIndicator extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "key_indicator_id")
    private Long id;

    private Short calendarYear;
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

}

