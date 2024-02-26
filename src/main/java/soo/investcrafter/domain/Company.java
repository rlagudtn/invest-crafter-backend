package soo.investcrafter.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Entity
@Getter
@Table(name = "company")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Company extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long id;

    private String name;

    @Column(length = 64)
    private String symbol;

    @Column(length = 64)
    private String industry;

    @Column(length = 16)
    private String exchange;

    @Column(length = 64)
    private String country;

    @OneToMany(mappedBy = "company")
    private List<KeyIndicator> keyIndicators;
}
