package soo.investcrafter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soo.investcrafter.domain.Company;
import soo.investcrafter.dto.CompanyDto;
import soo.investcrafter.repository.CompanyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;


    public List<CompanyDto> getCompanyWithLatestKeyIndicator() {
        List<Company> companies = companyRepository.findAllCompaniesWithLatestKeyIndicator();
        return companies.stream().map(company -> new CompanyDto(company, company.getKeyIndicators().get(0)))
                .collect(Collectors.toList());
    }


}
