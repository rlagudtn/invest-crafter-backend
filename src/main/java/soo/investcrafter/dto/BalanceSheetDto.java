package soo.investcrafter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import soo.investcrafter.domain.BalanceSheet;

@Data
@AllArgsConstructor
public class BalanceSheetDto {
    private Long id;
    private String calendarYear;
    private Long inventory;
    private Long propertyPlantEquipmentNet;
    private Long totalLiabilities;
    private Long totalEquity;
    private String url;

    public BalanceSheetDto(BalanceSheet balanceSheet) {
        this.id = balanceSheet.getId();
        this.calendarYear = balanceSheet.getCalendarYear();
        this.inventory = balanceSheet.getInventory();
        this.propertyPlantEquipmentNet = balanceSheet.getPropertyPlantEquipmentNet();
        this.totalLiabilities = balanceSheet.getTotalLiabilities();
        this.totalEquity = balanceSheet.getTotalEquity();
        this.url = balanceSheet.getUrl();
    }
}
