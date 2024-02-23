package soo.investcrafter.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "balance_sheet")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BalanceSheet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "balance_sheet_id")
    private Long id;

    @Column(length = 8)
    private String calendarYear;

    private Long inventory;
    private Long propertyPlantEquipmentNet;
    private Long totalLiabilities;
    private Long totalEquity;

    @Column(length = 256)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;


}
