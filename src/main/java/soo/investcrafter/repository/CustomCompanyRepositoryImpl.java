package soo.investcrafter.repository;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
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
import soo.investcrafter.domain.*;
import soo.investcrafter.dto.SearchCriteriaDto;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static soo.investcrafter.domain.QBalanceSheet.balanceSheet;
import static soo.investcrafter.domain.QCashFlowStatement.cashFlowStatement;
import static soo.investcrafter.domain.QCompany.company;
import static soo.investcrafter.domain.QIncomeStatement.incomeStatement;
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

        return companies;

    }

    @Override
    public Page<Company> findAllCompaniesWithLatestKeyIndicator(Pageable pageable, SearchCriteriaDto searchCriteria) {
        JPAQuery<Company> query = queryFactory.selectFrom(company)
                .innerJoin(company.keyIndicators, keyIndicator)
                .fetchJoin()
                .where(buildWhereClause(searchCriteria))
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

    @Override
    public Page<Company> findCompaniesWithLKeyIndicatorByKeyword(String keyword, Pageable pageable) {

        JPAQuery<Company> query = queryFactory.selectFrom(company)
                .innerJoin(company.keyIndicators, keyIndicator)
                .where(company.name.contains(keyword).or(company.symbol.contains(keyword)))
                .fetchJoin()
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());

        List<Company> fetchedCompanies = query.fetch();
        Long count = queryFactory
                .select(company.count())
                .from(company)
                .innerJoin(company.keyIndicators, keyIndicator)
                .where(company.name.contains(keyword).or(company.symbol.contains(keyword)))
                .fetchJoin()
                .fetchCount();

        return new PageImpl<>(fetchedCompanies, pageable, count);
    }

    @Override
    public Optional<Company> findCompanyWithStatementsById(Long id) {
        int LATEST=5;
        Integer currentYear = LocalDate.now().getYear();
        Company found = queryFactory.selectFrom(company)
                .leftJoin(company.balanceSheets, balanceSheet)
                .leftJoin(company.incomeStatements, incomeStatement)
                .leftJoin(company.cashFlowStatements, cashFlowStatement)
                .where(company.id.eq(id))
                .fetchOne();

        // 데이터가 로드된 후, 자바에서 필터링과 정렬을 진행
        if (found != null) {
            List<BalanceSheet> balanceSheets = found.getBalanceSheets().stream()
                    .sorted(Comparator.comparing(BalanceSheet::getCalendarYear).reversed())
                    .limit(LATEST)
                    .collect(Collectors.toList());

            List<IncomeStatement> incomeStatements = found.getIncomeStatements().stream()
                    .sorted(Comparator.comparing(IncomeStatement::getCalendarYear).reversed())
                    .limit(LATEST)

                    .collect(Collectors.toList());

            List<CashFlowStatement> cashFlowStatements = found.getCashFlowStatements().stream()
                    .sorted(Comparator.comparing(CashFlowStatement::getCalendarYear).reversed())
                    .limit(LATEST)
                    .collect(Collectors.toList());

            found.updateStatements(balanceSheets,incomeStatements,cashFlowStatements);
        }
        log.info("found >>> {}",found);

        return Optional.ofNullable(found);
    }


    // 모든 조건을 조합하는 메소드
    private BooleanExpression buildWhereClause(SearchCriteriaDto criteria) {
        return allOf(
                minPegGoe(criteria.getMinPeg()),
                maxPegLoe(criteria.getMaxPeg()),
                minDebtRatioGoe(criteria.getMinDebtRatio()),
                maxDebtRatioLoe(criteria.getMaxDebtRatio()),
                minRoeRecent1yrGoe(criteria.getMinRoeRecent1yr()),
                maxRoeRecent1yrLoe(criteria.getMaxRoeRecent1yr()),
                minRoeRecent2yrGoe(criteria.getMinRoeRecent2yr()),
                maxRoeRecent2yrLoe(criteria.getMaxRoeRecent2yr()),
                minRoeRecent3yrGoe(criteria.getMinRoeRecent3yr()),
                maxRoeRecent3yrLoe(criteria.getMaxRoeRecent3yr()),
                minOpmRecent1yrGoe(criteria.getMinOpmRecent1yr()),
                maxOpmRecent1yrLoe(criteria.getMaxOpmRecent1yr()),
                minOpmRecent2yrGoe(criteria.getMinOpmRecent2yr()),
                maxOpmRecent2yrLoe(criteria.getMaxOpmRecent2yr()),
                minOpmRecent3yrGoe(criteria.getMinOpmRecent3yr()),
                maxOpmRecent3yrLoe(criteria.getMaxOpmRecent3yr()),
                minFreeCashFlowGoe(criteria.getMinFreeCashFlow()),
                maxFreeCashFlowLoe(criteria.getMaxFreeCashFlow()),
                minDividendYieldGoe(criteria.getMinDividendYield()),
                maxDividendYieldLoe(criteria.getMaxDividendYield()),
                minPbrGoe(criteria.getMinPbr()),
                maxPbrLoe(criteria.getMaxPbr()),
                minPerGoe(criteria.getMinPer()),
                maxPerLoe(criteria.getMaxPer()),
                minOperatingActivitiesCashFlowGoe(criteria.getMinOperatingActivitiesCashFlow()),
                maxOperatingActivitiesCashFlowLoe(criteria.getMaxOperatingActivitiesCashFlow()),
                minInvestingActivitiesCashFlowGoe(criteria.getMinInvestingActivitiesCashFlow()),
                maxInvestingActivitiesCashFlowLoe(criteria.getMaxInvestingActivitiesCashFlow()),
                minFinancingActivitiesCashFlowGoe(criteria.getMinFinancingActivitiesCashFlow()),
                maxFinancingActivitiesCashFlowLoe(criteria.getMaxFinancingActivitiesCashFlow())
        );
    }

    // 여러 BooleanExpression 조건들을 AND 연산으로 결합
    private BooleanExpression allOf(BooleanExpression... expressions) {
        BooleanExpression result = null;
        for (BooleanExpression expression : expressions) {
            result = result == null ? expression : result.and(expression);
        }
        return result;
    }


    // 기타 필요한 필드나 메소드
    private BooleanExpression minPegGoe(Float minPeg) {
        return minPeg != null ? keyIndicator.peg.goe(minPeg) : null;
    }

    private BooleanExpression maxPegLoe(Float maxPeg) {
        return maxPeg != null ? keyIndicator.peg.loe(maxPeg) : null;
    }

    private BooleanExpression minDebtRatioGoe(Float minDebtRatio) {
        return minDebtRatio != null ? keyIndicator.debtRatio.goe(minDebtRatio) : null;
    }
    private BooleanExpression maxDebtRatioLoe(Float maxDebtRatio) {
        return maxDebtRatio != null ? keyIndicator.debtRatio.loe(maxDebtRatio) : null;
    }

    private BooleanExpression minRoeRecent1yrGoe(Float minRoeRecent1yr) {
        return minRoeRecent1yr != null ? keyIndicator.roeRecent1yr.goe(minRoeRecent1yr) : null;
    }

    private BooleanExpression maxRoeRecent1yrLoe(Float maxRoeRecent1yr) {
        return maxRoeRecent1yr != null ? keyIndicator.roeRecent1yr.loe(maxRoeRecent1yr) : null;
    }

    private BooleanExpression minRoeRecent2yrGoe(Float minRoeRecent2yr) {
        return minRoeRecent2yr != null ? keyIndicator.roeRecent2yr.goe(minRoeRecent2yr) : null;
    }

    private BooleanExpression maxRoeRecent2yrLoe(Float maxRoeRecent2yr) {
        return maxRoeRecent2yr != null ? keyIndicator.roeRecent2yr.loe(maxRoeRecent2yr) : null;
    }

    private BooleanExpression minRoeRecent3yrGoe(Float minRoeRecent3yr) {
        return minRoeRecent3yr != null ? keyIndicator.roeRecent3yr.goe(minRoeRecent3yr) : null;
    }

    private BooleanExpression maxRoeRecent3yrLoe(Float maxRoeRecent3yr) {
        return maxRoeRecent3yr != null ? keyIndicator.roeRecent3yr.loe(maxRoeRecent3yr) : null;
    }

    private BooleanExpression minOpmRecent1yrGoe(Float minOpmRecent1yr) {
        return minOpmRecent1yr != null ? keyIndicator.opmRecent1yr.goe(minOpmRecent1yr) : null;
    }

    private BooleanExpression maxOpmRecent1yrLoe(Float maxOpmRecent1yr) {
        return maxOpmRecent1yr != null ? keyIndicator.opmRecent1yr.loe(maxOpmRecent1yr) : null;
    }

    private BooleanExpression minOpmRecent2yrGoe(Float minOpmRecent2yr) {
        return minOpmRecent2yr != null ? keyIndicator.opmRecent2yr.goe(minOpmRecent2yr) : null;
    }

    private BooleanExpression maxOpmRecent2yrLoe(Float maxOpmRecent2yr) {
        return maxOpmRecent2yr != null ? keyIndicator.opmRecent2yr.loe(maxOpmRecent2yr) : null;
    }

    private BooleanExpression minOpmRecent3yrGoe(Float minOpmRecent3yr) {
        return minOpmRecent3yr != null ? keyIndicator.opmRecent3yr.goe(minOpmRecent3yr) : null;
    }

    private BooleanExpression maxOpmRecent3yrLoe(Float maxOpmRecent3yr) {
        return maxOpmRecent3yr != null ? keyIndicator.opmRecent3yr.loe(maxOpmRecent3yr) : null;
    }

    private BooleanExpression minFreeCashFlowGoe(Long minFreeCashFlow) {
        return minFreeCashFlow != null ? keyIndicator.freeCashFlow.goe(minFreeCashFlow) : null;
    }

    private BooleanExpression maxFreeCashFlowLoe(Long maxFreeCashFlow) {
        return maxFreeCashFlow != null ? keyIndicator.freeCashFlow.loe(maxFreeCashFlow) : null;
    }

    private BooleanExpression minDividendYieldGoe(Float minDividendYield) {
        return minDividendYield != null ? keyIndicator.dividendYield.goe(minDividendYield) : null;
    }

    private BooleanExpression maxDividendYieldLoe(Float maxDividendYield) {
        return maxDividendYield != null ? keyIndicator.dividendYield.loe(maxDividendYield) : null;
    }

    private BooleanExpression minPbrGoe(Float minPbr) {
        return minPbr != null ? keyIndicator.pbr.goe(minPbr) : null;
    }

    private BooleanExpression maxPbrLoe(Float maxPbr) {
        return maxPbr != null ? keyIndicator.pbr.loe(maxPbr) : null;
    }

    private BooleanExpression minPerGoe(Float minPer) {
        return minPer != null ? keyIndicator.per.goe(minPer) : null;
    }

    private BooleanExpression maxPerLoe(Float maxPer) {
        return maxPer != null ? keyIndicator.per.loe(maxPer) : null;
    }

    private BooleanExpression minOperatingActivitiesCashFlowGoe(Long minOperatingActivitiesCashFlow) {
        return minOperatingActivitiesCashFlow != null ? keyIndicator.operatingActivitiesCashFlow.goe(minOperatingActivitiesCashFlow) : null;
    }

    private BooleanExpression maxOperatingActivitiesCashFlowLoe(Long maxOperatingActivitiesCashFlow) {
        return maxOperatingActivitiesCashFlow != null ? keyIndicator.operatingActivitiesCashFlow.loe(maxOperatingActivitiesCashFlow) : null;
    }

    private BooleanExpression minInvestingActivitiesCashFlowGoe(Long minInvestingActivitiesCashFlow) {
        return minInvestingActivitiesCashFlow != null ? keyIndicator.investingActivitiesCashFlow.goe(minInvestingActivitiesCashFlow) : null;
    }

    private BooleanExpression maxInvestingActivitiesCashFlowLoe(Long maxInvestingActivitiesCashFlow) {
        return maxInvestingActivitiesCashFlow != null ? keyIndicator.investingActivitiesCashFlow.loe(maxInvestingActivitiesCashFlow) : null;
    }

    private BooleanExpression minFinancingActivitiesCashFlowGoe(Long minFinancingActivitiesCashFlow) {
        return minFinancingActivitiesCashFlow != null ? keyIndicator.financingActivitiesCashFlow.goe(minFinancingActivitiesCashFlow) : null;
    }

    private BooleanExpression maxFinancingActivitiesCashFlowLoe(Long maxFinancingActivitiesCashFlow) {
        return maxFinancingActivitiesCashFlow != null ? keyIndicator.financingActivitiesCashFlow.loe(maxFinancingActivitiesCashFlow) : null;
    }



}
