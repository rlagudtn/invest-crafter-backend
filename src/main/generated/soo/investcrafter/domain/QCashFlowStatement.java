package soo.investcrafter.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCashFlowStatement is a Querydsl query type for CashFlowStatement
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCashFlowStatement extends EntityPathBase<CashFlowStatement> {

    private static final long serialVersionUID = -789891755L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCashFlowStatement cashFlowStatement = new QCashFlowStatement("cashFlowStatement");

    public final StringPath calendarYear = createString("calendarYear");

    public final QCompany company;

    public final NumberPath<Long> dividendsPaid = createNumber("dividendsPaid", Long.class);

    public final NumberPath<Long> financingActivitiesCashFlow = createNumber("financingActivitiesCashFlow", Long.class);

    public final NumberPath<Long> freeCashFlow = createNumber("freeCashFlow", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> investingActivitiesCashFlow = createNumber("investingActivitiesCashFlow", Long.class);

    public final NumberPath<Long> operatingActivitiesCashFlow = createNumber("operatingActivitiesCashFlow", Long.class);

    public final NumberPath<Long> totalEquity = createNumber("totalEquity", Long.class);

    public final StringPath url = createString("url");

    public QCashFlowStatement(String variable) {
        this(CashFlowStatement.class, forVariable(variable), INITS);
    }

    public QCashFlowStatement(Path<? extends CashFlowStatement> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCashFlowStatement(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCashFlowStatement(PathMetadata metadata, PathInits inits) {
        this(CashFlowStatement.class, metadata, inits);
    }

    public QCashFlowStatement(Class<? extends CashFlowStatement> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompany(forProperty("company")) : null;
    }

}

