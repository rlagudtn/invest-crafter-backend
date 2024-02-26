package soo.investcrafter.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.criteria.JpaSubQuery;
import soo.investcrafter.domain.Company;
import soo.investcrafter.domain.QCompany;
import soo.investcrafter.domain.QKeyIndicator;

import java.util.List;

import static soo.investcrafter.domain.QCompany.company;
import static soo.investcrafter.domain.QKeyIndicator.keyIndicator;

@RequiredArgsConstructor
public class CustomCompanyRepositoryImpl implements CustomCompanyRepository {
    private final JPAQueryFactory queryFactory;
    private final EntityManager em;

    @Override
    public List<Company> findAllCompaniesWithLatestKeyIndicator() {
        List<Company> companies = queryFactory.selectFrom(company)
                .innerJoin(company.keyIndicators, keyIndicator)
                .fetchJoin().fetch();
        System.out.println("length >>>");
        System.out.println(companies.size());
        return companies;

    }
}
