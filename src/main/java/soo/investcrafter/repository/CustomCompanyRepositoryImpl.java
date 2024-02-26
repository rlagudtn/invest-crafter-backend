package soo.investcrafter.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.criteria.JpaSubQuery;
import soo.investcrafter.domain.Company;

import java.util.List;

@RequiredArgsConstructor
public class CustomCompanyRepositoryImpl implements CustomCompanyRepository {
    private final JPAQueryFactory queryFactory;
    private final EntityManager em;

    @Override
    public List<Company> findAllCompaniesWithLatestKeyIndicator() {
//        List<CompanyKeyIndicatorDTO> results = queryFactory
//                .select(Projections.constructor(CompanyKeyIndicatorDTO.class,
//                        company.id.as("companyId"),
//                        company.name.as("companyName"),
//                        keyIndicator.id.as("keyIndicatorId"),
//                        keyIndicator.calendarYear.as("calendarYear")))
//                .from(company)
//                .join(company.keyIndicators, keyIndicator)
//                .where(keyIndicator.calendarYear.eq(
//                        JPAExpressions.select(keyIndicator.calendarYear.max())
//                                .from(keyIndicator)
//                                .where(keyIndicator.company.eq(company))
//                ))
//                .fetch();
        return null;
    }
}
