package soo.investcrafter.dto;

import lombok.Data;
import soo.investcrafter.domain.Company;
import soo.investcrafter.domain.KeyIndicator;

@Data
public class CompanyDto {
    private Long id;
    private String name;
    private String symbol;
    private String industry;
    private String exchange;
    private String country;

    private KeyIndicatorDto keyIndicator = null;

    public CompanyDto(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.symbol = company.getSymbol();
        this.industry = company.getIndustry();
        this.exchange = company.getExchange();
        this.country = company.getCountry();
    }

    public CompanyDto(Company company, KeyIndicator keyIndicator) {
        this(company);
        this.keyIndicator =new KeyIndicatorDto(keyIndicator);
    }

}
