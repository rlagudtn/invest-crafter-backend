package soo.investcrafter.repository;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.criteria.JpaSubQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.support.PageableExecutionUtils;
import soo.investcrafter.domain.Company;
import soo.investcrafter.domain.QCompany;
import soo.investcrafter.domain.QKeyIndicator;

import java.util.List;

import static soo.investcrafter.domain.QCompany.company;
import static soo.investcrafter.domain.QKeyIndicator.keyIndicator;

@RequiredArgsConstructor
@Slf4j
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

    @Override
    public Page<Company> findAllCompaniesWithLatestKeyIndicator(Pageable pageable) {
        JPAQuery<Company> query = queryFactory.selectFrom(company)
                .innerJoin(company.keyIndicators, keyIndicator)
                .fetchJoin()
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());

        // 정렬 처리를 위해 Sort 객체 순회
        for (Sort.Order order : pageable.getSort()) {
            PathBuilder<?> entityPath = new PathBuilder<>(keyIndicator.getType(), keyIndicator.getMetadata());
            query.orderBy(new OrderSpecifier(
                    order.isAscending() ? com.querydsl.core.types.Order.ASC : com.querydsl.core.types.Order.DESC,
                    entityPath.get(order.getProperty())));
        }
        List<Company> content = query.fetch();
        Long count = queryFactory
                .select(company.count())
                .from(company)
                .innerJoin(company.keyIndicators, keyIndicator)
                .fetchJoin()
                .fetchCount();

        return new PageImpl<>(content, pageable,count);
    }
}
