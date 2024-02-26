package soo.investcrafter.repository;

import org.springframework.stereotype.Repository;
import soo.investcrafter.domain.Company;

import java.util.List;

@Repository
public interface CustomCompanyRepository {
    List<Company> findAllCompaniesWithLatestKeyIndicator();
}
