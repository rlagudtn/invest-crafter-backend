package soo.investcrafter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soo.investcrafter.domain.Company;

public interface CompanyRepository extends JpaRepository<Company,Long>,CustomCompanyRepository {


}
