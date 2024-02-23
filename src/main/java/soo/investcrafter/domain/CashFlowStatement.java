package soo.investcrafter.domain;

import jakarta.persistence.*;

//@Entity
//@Table(name = "cash_flow_statement")
public class CashFlowStatement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
