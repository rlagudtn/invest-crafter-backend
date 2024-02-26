package soo.investcrafter.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBalanceSheet is a Querydsl query type for BalanceSheet
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBalanceSheet extends EntityPathBase<BalanceSheet> {

    private static final long serialVersionUID = -2118559332L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBalanceSheet balanceSheet = new QBalanceSheet("balanceSheet");

    public final StringPath calendarYear = createString("calendarYear");

    public final QCompany company;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> inventory = createNumber("inventory", Long.class);

    public final NumberPath<Long> propertyPlantEquipmentNet = createNumber("propertyPlantEquipmentNet", Long.class);

    public final NumberPath<Long> totalEquity = createNumber("totalEquity", Long.class);

    public final NumberPath<Long> totalLiabilities = createNumber("totalLiabilities", Long.class);

    public final StringPath url = createString("url");

    public QBalanceSheet(String variable) {
        this(BalanceSheet.class, forVariable(variable), INITS);
    }

    public QBalanceSheet(Path<? extends BalanceSheet> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBalanceSheet(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBalanceSheet(PathMetadata metadata, PathInits inits) {
        this(BalanceSheet.class, metadata, inits);
    }

    public QBalanceSheet(Class<? extends BalanceSheet> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompany(forProperty("company")) : null;
    }

}

