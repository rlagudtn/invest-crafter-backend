package soo.investcrafter.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QKeyIndicator is a Querydsl query type for KeyIndicator
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QKeyIndicator extends EntityPathBase<KeyIndicator> {

    private static final long serialVersionUID = -663524311L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QKeyIndicator keyIndicator = new QKeyIndicator("keyIndicator");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath calendarYear = createString("calendarYear");

    public final QCompany company;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Float> debtRatio = createNumber("debtRatio", Float.class);

    public final NumberPath<Float> dividendYield = createNumber("dividendYield", Float.class);

    public final NumberPath<Long> financingActivitiesCashFlow = createNumber("financingActivitiesCashFlow", Long.class);

    public final NumberPath<Long> freeCashFlow = createNumber("freeCashFlow", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> investingActivitiesCashFlow = createNumber("investingActivitiesCashFlow", Long.class);

    public final NumberPath<Long> operatingActivitiesCashFlow = createNumber("operatingActivitiesCashFlow", Long.class);

    public final NumberPath<Float> opmRecent1yr = createNumber("opmRecent1yr", Float.class);

    public final NumberPath<Float> opmRecent2yr = createNumber("opmRecent2yr", Float.class);

    public final NumberPath<Float> opmRecent3yr = createNumber("opmRecent3yr", Float.class);

    public final NumberPath<Float> pbr = createNumber("pbr", Float.class);

    public final NumberPath<Float> peg = createNumber("peg", Float.class);

    public final NumberPath<Float> per = createNumber("per", Float.class);

    public final NumberPath<Float> roeRecent1yr = createNumber("roeRecent1yr", Float.class);

    public final NumberPath<Float> roeRecent2yr = createNumber("roeRecent2yr", Float.class);

    public final NumberPath<Float> roeRecent3yr = createNumber("roeRecent3yr", Float.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QKeyIndicator(String variable) {
        this(KeyIndicator.class, forVariable(variable), INITS);
    }

    public QKeyIndicator(Path<? extends KeyIndicator> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QKeyIndicator(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QKeyIndicator(PathMetadata metadata, PathInits inits) {
        this(KeyIndicator.class, metadata, inits);
    }

    public QKeyIndicator(Class<? extends KeyIndicator> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompany(forProperty("company")) : null;
    }

}

