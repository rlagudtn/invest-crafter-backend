package soo.investcrafter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import soo.investcrafter.domain.Company;
import soo.investcrafter.dto.CompanyDto;
import soo.investcrafter.dto.CompanyWithStatementsDto;
import soo.investcrafter.dto.SearchCriteriaDto;
import soo.investcrafter.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;
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

    public Page<CompanyDto> getCompanyWithLatestKeyIndicator(Pageable pageable, SearchCriteriaDto searchCriteria) {
        Page<Company> companies = companyRepository.findAllCompaniesWithLatestKeyIndicator(pageable,searchCriteria);
        return companies.map(company -> new CompanyDto(company,
                company.getKeyIndicators().isEmpty() ? null : company.getKeyIndicators().get(0)));

    }


    public Page<CompanyDto> searchCompaniesByKeyword(String keyword, Pageable pageable) {
        Page<Company> searchedCompanies=companyRepository.findCompaniesWithLKeyIndicatorByKeyword(keyword,pageable);

        return searchedCompanies.map(company -> new CompanyDto(company,
                company.getKeyIndicators().isEmpty() ? null : company.getKeyIndicators().get(0)));
    }

    public CompanyWithStatementsDto getCompanyWithStatements(Long id) {
        Company company= companyRepository.findCompanyWithStatementsById(id).orElseThrow();

        return new CompanyWithStatementsDto(company);
    }
}
