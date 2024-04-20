package soo.investcrafter.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import soo.investcrafter.domain.Company;
import soo.investcrafter.dto.SearchCriteriaDto;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomCompanyRepository {
    List<Company> findAllCompaniesWithLatestKeyIndicator();

    Page<Company> findAllCompaniesWithLatestKeyIndicator(Pageable pageable, SearchCriteriaDto searchCriteriaDto);

    Page<Company> findCompaniesWithLKeyIndicatorByKeyword(String keyword, Pageable pageable);

    Optional<Company> findCompanyWithStatementsById(Long id);
}
