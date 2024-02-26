package soo.investcrafter.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QIncomeStatement is a Querydsl query type for IncomeStatement
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QIncomeStatement extends EntityPathBase<IncomeStatement> {

    private static final long serialVersionUID = 150109549L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QIncomeStatement incomeStatement = new QIncomeStatement("incomeStatement");

    public final StringPath calendarYear = createString("calendarYear");

    public final QCompany company;

    public final NumberPath<Float> eps = createNumber("eps", Float.class);

    public final NumberPath<Long> incomeStatementId = createNumber("incomeStatementId", Long.class);

    public final NumberPath<Long> netIncome = createNumber("netIncome", Long.class);

    public final NumberPath<Long> operatingIncome = createNumber("operatingIncome", Long.class);

    public final NumberPath<Float> opm = createNumber("opm", Float.class);

    public final NumberPath<Long> researchAndDevelop = createNumber("researchAndDevelop", Long.class);

    public final NumberPath<Long> revenue = createNumber("revenue", Long.class);

    public final StringPath url = createString("url");

    public QIncomeStatement(String variable) {
        this(IncomeStatement.class, forVariable(variable), INITS);
    }

    public QIncomeStatement(Path<? extends IncomeStatement> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QIncomeStatement(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QIncomeStatement(PathMetadata metadata, PathInits inits) {
        this(IncomeStatement.class, metadata, inits);
    }

    public QIncomeStatement(Class<? extends IncomeStatement> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompany(forProperty("company")) : null;
    }

}

