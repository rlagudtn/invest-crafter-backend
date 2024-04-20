package soo.investcrafter.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCompany is a Querydsl query type for Company
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCompany extends EntityPathBase<Company> {

    private static final long serialVersionUID = -1963795676L;

    public static final QCompany company = new QCompany("company");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final ListPath<BalanceSheet, QBalanceSheet> balanceSheets = this.<BalanceSheet, QBalanceSheet>createList("balanceSheets", BalanceSheet.class, QBalanceSheet.class, PathInits.DIRECT2);

    public final ListPath<CashFlowStatement, QCashFlowStatement> cashFlowStatements = this.<CashFlowStatement, QCashFlowStatement>createList("cashFlowStatements", CashFlowStatement.class, QCashFlowStatement.class, PathInits.DIRECT2);

    public final StringPath country = createString("country");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath exchange = createString("exchange");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<IncomeStatement, QIncomeStatement> incomeStatements = this.<IncomeStatement, QIncomeStatement>createList("incomeStatements", IncomeStatement.class, QIncomeStatement.class, PathInits.DIRECT2);

    public final StringPath industry = createString("industry");

    public final ListPath<KeyIndicator, QKeyIndicator> keyIndicators = this.<KeyIndicator, QKeyIndicator>createList("keyIndicators", KeyIndicator.class, QKeyIndicator.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath symbol = createString("symbol");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QCompany(String variable) {
        super(Company.class, forVariable(variable));
    }

    public QCompany(Path<? extends Company> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCompany(PathMetadata metadata) {
        super(Company.class, metadata);
    }

}

